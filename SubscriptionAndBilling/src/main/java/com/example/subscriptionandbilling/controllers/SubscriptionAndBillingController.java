package com.example.subscriptionandbilling.controllers;

import com.example.subscriptionandbilling.models.SubscriptionAndBilling;
import com.example.subscriptionandbilling.services.SubscriptionAndBillingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionAndBillingController {
    private final SubscriptionAndBillingService subscriptionService;

    public SubscriptionAndBillingController(SubscriptionAndBillingService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }
    @PostMapping
    public ResponseEntity<SubscriptionAndBilling> create(@RequestBody SubscriptionRequest request) {
        // The "request" object contains the providerId from Postman
        SubscriptionAndBilling newSubscription = subscriptionService.createSubscription(request.getProviderId(), request.getPlan());
        return new ResponseEntity<>(newSubscription, HttpStatus.CREATED);
    }
}
class SubscriptionRequest {
    private Integer providerId;
    private String plan;

    public Integer getProviderId() {
        return providerId;
    }

    public String getPlan() {
        return plan;
    }
}

