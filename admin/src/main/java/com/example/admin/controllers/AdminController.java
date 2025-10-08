package com.example.admin.controllers;


import com.example.admin.models.ProviderDto;
import com.example.admin.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PatchMapping("/approve-provider/{providerId}")
    public ResponseEntity<ProviderDto> approveProvider(@PathVariable Long providerId) {
        // Call the AdminService to perform the action
        ProviderDto approvedProvider = adminService.approveProvider(providerId);
        return ResponseEntity.ok(approvedProvider);
    }


    @GetMapping("/providers/pending")
    public ResponseEntity<List<ProviderDto>> getPendingProviders() {
        List<ProviderDto> pendingProviders = adminService.getPendingProviders();
        return ResponseEntity.ok(pendingProviders);
    }

//    private final AdminService adminService;
//
//    public AdminController(AdminService adminService) {
//        this.adminService = adminService;
//    }
//    @PatchMapping("/approve-provider/{providerId}")
//    public ResponseEntity<Provider> approveProvider(@PathVariable Integer providerId) {
//        Provider approvedProvider = adminService.approveProvider(providerId);
//        return new ResponseEntity<>(approvedProvider, HttpStatus.OK);
//    }
//    @PatchMapping("/providers/{providerId}/approve")
//    public ResponseEntity<ProviderDto> approveProvider(@PathVariable Long providerId) {
//        ProviderDto approvedProviderDto = providerService.approveProvider(providerId);
//        return ResponseEntity.ok(approvedProviderDto);
//    }
//    @GetMapping("/providers/pending")
//    public ResponseEntity<List<Provider>> getPendingProviders() {
//        List<Provider> pendingProviders = adminService.getPendingProviders();
//        return new ResponseEntity<>(pendingProviders, HttpStatus.OK);
//    }
}
