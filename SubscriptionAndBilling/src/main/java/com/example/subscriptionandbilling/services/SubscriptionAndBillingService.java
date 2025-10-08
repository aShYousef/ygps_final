package com.example.subscriptionandbilling.services;

import com.example.subscriptionandbilling.models.ProviderDto;
import com.example.subscriptionandbilling.models.SubscriptionAndBilling;
import com.example.subscriptionandbilling.repositories.SubscriptionAndBillingRepository;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
//import java.util.UUID;

@Service
public class SubscriptionAndBillingService {

    private final SubscriptionAndBillingRepository subscriptionRepository;
    private final RestTemplate restTemplate;
//    private final KafkaTemplate<Integer, SubscriptionAndBilling> kafkaTemplate;

    public SubscriptionAndBillingService(SubscriptionAndBillingRepository repo/*, KafkaTemplate<Integer, SubscriptionAndBilling> template*/) {
        this.subscriptionRepository = repo;
        this.restTemplate = new RestTemplate();
//        this.kafkaTemplate = template;
    }
//    public SubscriptionAndBilling createSubscription(Integer providerId, String plan) {
//        // --- ✅ الخطوة الجديدة: التحقق من حالة المزود ---
//        ProviderDto provider = getProviderDetails(providerId);
//        if (!"ACTIVE".equalsIgnoreCase(provider.getStatus())) {
//            throw new IllegalStateException("Provider is not active and cannot subscribe.");
//        }
//        SubscriptionAndBilling sub = new SubscriptionAndBilling();
//        sub.setProviderId(providerId);
//        sub.setPlan(plan);
//        sub.setStatus("ACTIVE");
//        sub.setStartDate(LocalDate.now());
//        sub.setEndDate(LocalDate.now().plusMonths(1));
//        SubscriptionAndBilling savedSub = subscriptionRepository.save(sub);
//        updateProviderSubscriptionStatus(providerId, true);
//
//        return savedSub;
//    }
//
//    // دالة مساعدة جديدة لاستدعاء Provider Service
//    private ProviderDto getProviderDetails(Integer providerId) {
//        String url = "http://localhost:9001/provider/" + providerId;
//        try {
//            return restTemplate.getForObject(url, ProviderDto.class);
//        } catch (HttpClientErrorException.NotFound ex) {
//            throw new RuntimeException("Provider not found with id: " + providerId);
//        }
//    }

//    public SubscriptionAndBilling createSubscription(Integer providerId, String plan) {
//
//        SubscriptionAndBilling sub = new SubscriptionAndBilling();
//        sub.setProviderId(providerId);
//        sub.setPlan(plan);
//        sub.setStatus("ACTIVE");
//        sub.setStartDate(LocalDate.now());
//        sub.setEndDate(LocalDate.now().plusMonths(1)); // اشتراك لمدة شهر
//        SubscriptionAndBilling savedSub = subscriptionRepository.save(sub);
//        // إرسال رسالة إلى Kafka لإعلام الخدمات الأخرى
////        kafkaTemplate.send("subscription-events", savedSub);
//        updateProviderSubscriptionStatus(providerId, true);
//        return savedSub;
//    }

private ProviderDto getProviderDetails(Integer providerId) {
    String url = "http://localhost:9001/api/providers/" + providerId;

    // This line tells RestTemplate:
    // "Call this URL and expect the response to be a ProviderDto"
    return restTemplate.getForObject(url, ProviderDto.class);
}


    // 1. غيّر نوع البيانات هنا إلى Long
    public SubscriptionAndBilling createSubscription(Integer providerId, String plan) {
        // --- التحقق من حالة المزود ---
        ProviderDto provider = getProviderDetails(providerId);
        if (!"ACTIVE".equalsIgnoreCase(provider.getStatus())) {
            throw new IllegalStateException("Provider is not active and cannot subscribe.");
        }

        SubscriptionAndBilling sub = new SubscriptionAndBilling();
        sub.setProviderId(providerId); // <-- سيقبل Long الآن
        sub.setPlan(plan);
        sub.setStatus("ACTIVE");
        sub.setStartDate(LocalDate.now());
        sub.setEndDate(LocalDate.now().plusMonths(1));

        SubscriptionAndBilling savedSub = subscriptionRepository.save(sub);

        updateProviderSubscriptionStatus(providerId, true);

        return savedSub;
    }

    // 2. غيّر نوع البيانات هنا أيضاً إلى Long
//    private ProviderDto getProviderDetails(Integer providerId) {
//        // 3. قم بتصحيح الرابط هنا
//        String url = "http://localhost:9001/api/providers/" + providerId;
//        try {
//            return restTemplate.getForObject(url, ProviderDto.class);
//        } catch (HttpClientErrorException.NotFound ex) {
//            throw new RuntimeException("Provider not found with id: " + providerId);
//        }
//    }

    // 4. غيّر نوع البيانات هنا أيضاً
    private void updateProviderSubscriptionStatus(Integer providerId, boolean isSubscribed) {
        String url = "http://localhost:9001/api/providers/" + providerId + "/subscription-status";
        Map<String, Boolean> requestBody = new HashMap<>();
        requestBody.put("isSubscribed", isSubscribed);
        restTemplate.postForEntity(url, requestBody, Void.class);
    }
}