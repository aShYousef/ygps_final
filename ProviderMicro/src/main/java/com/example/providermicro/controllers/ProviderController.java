package com.example.providermicro.controllers;
import com.example.providermicro.models.Provider;
import com.example.providermicro.models.ProviderDto;
import com.example.providermicro.services.ProviderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = {"/provider", "/api/providers"})
public class ProviderController {
    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping("/add")
    public ResponseEntity<Provider> addProvider(@RequestBody Provider provider) {
        Provider newProvider = this.providerService.AddProvider(provider);
        return new ResponseEntity<>(newProvider, HttpStatus.CREATED);
    }

    // --- Search Endpoint for Users ---
    @GetMapping("/city/{city}/category/{category}")
    public ResponseEntity<List<ProviderDto>> searchForProviders(
            @PathVariable String city,
            @PathVariable String category) {
        List<ProviderDto> providers = providerService.searchProvidersForUser(city, category);
        return ResponseEntity.ok(providers);
    }

    @GetMapping("/{providerId}")
    public ResponseEntity<ProviderDto> getProviderById(@PathVariable Integer providerId) {
        // 3. Always return DTOs to the client, not the full entity
        ProviderDto providerDto = providerService.getProviderDtoById(providerId);
        return ResponseEntity.ok(providerDto);
    }


    @PostMapping("/{providerId}/subscription-status")
    public ResponseEntity<Void> updateSubscriptionStatus(
            @PathVariable Integer providerId,
            @RequestBody Map<String, Boolean> request) {
        providerService.updateSubscriptionStatus(providerId, request.get("isSubscribed"));
        return ResponseEntity.ok().build();
    }
    @GetMapping("/pending")
    public ResponseEntity<List<ProviderDto>> getPendingProviders() {
        List<ProviderDto> providers = providerService.getPendingProviders();
        return ResponseEntity.ok(providers);
    }

    @PatchMapping("/providerId/{providerId}/status")
    @GetMapping("/")
    public ResponseEntity<List<Provider>> showAllProvider() {
        List<Provider> providers =this.providerService.getAllProviders();
        return  new ResponseEntity<>(providers, HttpStatus.OK);
    }

    @PatchMapping("/{providerId}/approve")
    public ResponseEntity<ProviderDto> approveProvider(@PathVariable Integer providerId) {
        ProviderDto approvedProvider = providerService.approveProvider(providerId);
        return ResponseEntity.ok(approvedProvider);
    }



//    @PatchMapping("/{providerId}/approve")
//    public ResponseEntity<ProviderDto> approveProvider(@PathVariable Integer providerId) {
//        Provider approvedProvider = providerService.approveProvider(providerId);
//        return new ResponseEntity<>(approvedProvider, HttpStatus.OK);
//    }

//    @GetMapping("/id/{id}")
//    public ResponseEntity<Provider> getProviderById(@PathVariable Integer id) {
//        Provider retrievedProvider = this.providerService.getItemById(id);
//        return new ResponseEntity<>(retrievedProvider, HttpStatus.OK);
//    }
//    @GetMapping("/{providerId}")
//    public ResponseEntity<ProviderDto> getProviderDtoById(@PathVariable Integer providerId) {
//        ProviderDto providerDto = providerService.getProviderDtoById(providerId);
//        return ResponseEntity.ok(providerDto);
//    }
//    public ProviderController(ProviderService providerService) {
//        this.providerService = providerService;
//    }

//    @GetMapping("/city/{city}/category/{category}")
//    public ResponseEntity<List<ProviderDto>> searchForProviders(
//            @PathVariable String city,
//            @PathVariable String category) {
//
//        List<ProviderDto> providers = providerService.searchProvidersForUser(city, category);
//        return ResponseEntity.ok(providers);
//    }

//    @PostMapping("/{providerId}/subscription-status")
//    public ResponseEntity<Void> updateSubscriptionStatus(
//            @PathVariable Integer providerId,
//            @RequestBody Map<String, Boolean> request) {
//        providerService.updateSubscriptionStatus(providerId, request.get("isSubscribed"));
//        return ResponseEntity.ok().build();
//    }




}
