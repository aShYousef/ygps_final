package com.example.admin.services;

import com.example.admin.VO.Provider;
import com.example.admin.models.ProviderDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class AdminService {

    private final RestTemplate restTemplate;
    public AdminService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProviderDto approveProvider(Long providerId) {
        // This is the URL of the Provider microservice's "approve" endpoint
        String url = "http://localhost:9001/api/providers/" + providerId + "/approve";

        // Make the PATCH request and get the updated ProviderDto back
        // For a PATCH request, you might need to use the exchange() method.
        // This is a simplified example; see note below.
        return restTemplate.patchForObject(url, null, ProviderDto.class);
    }
    public List<ProviderDto> getPendingProviders() {
        // This is the URL of the new endpoint on the Provider service
        String url = "http://localhost:9001/api/providers/pending";

        ProviderDto[] response = restTemplate.getForObject(url, ProviderDto[].class);

        if (response == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(response);
    }
}

//    public List<Provider> getPendingProviders() {
//        // 1. Define the URL of the Provider microservice's endpoint
//        String url = "http://localhost:9001/api/admin/providers/pending";
//
//        // 2. Make the GET request and get the response as an array of ProviderDtos
//        Provider[] pendingProvidersArray = restTemplate.getForObject(url, Provider[].class);
//
//        // 3. Convert the array to a List and return it
//        return Arrays.asList(pendingProvidersArray);
//    }

