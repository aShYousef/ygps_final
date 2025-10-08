//package com.example.providermicro.subscription;
//
//import com.example.providermicro.models.Provider;
//import com.example.providermicro.services.ProviderService;
//import org.springframework.stereotype.Service;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SubscriptionEventListener {
//    private final ProviderService providerService;
//    public SubscriptionEventListener(ProviderService providerService) {
//        this.providerService = providerService;
//    }
//
//    @KafkaListener(topics = "subscription-events", groupId = "provider_group")
//    public void handleSubscriptionEvent(SubscriptionDto subscriptionDto) {
//        System.out.println("Received subscription event for user: " + subscriptionDto.getProviderId());
//
//        // المنطق الذي تريد تنفيذه
//        // على سبيل المثال، ابحث عن المزود المرتبط بهذا المستخدم وقم بتحديث حالته
//        // providerService.upgradeProviderPlan(subscriptionDto.getUserId(), subscriptionDto.getPlan());
//    }
//}
