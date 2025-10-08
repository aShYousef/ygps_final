package com.example.providermicro.services;

import com.example.providermicro.models.Provider;
import com.example.providermicro.models.ProviderDto;
import com.example.providermicro.repositories.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProviderService {
    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }
    /**
     * Searches for providers and returns a list of DTOs safe for the user to see.
     */
    public ProviderDto getProviderDtoById(Integer providerId) {
        // 1. Find the provider entity from the database
        Provider provider = providerRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found with id: " + providerId));

        // 2. Convert the entity to a DTO using your helper method
        return convertToDto(provider);
    }
    public List<ProviderDto> searchProvidersForUser(String city, String category) {
        // 1. Get the full provider objects from the database, sorted
        List<Provider> providersFromDb = providerRepository
                .findByCityAndCategoryAndStatusIgnoreCaseOrderByIsSubscribedDesc(city, category, "ACTIVE");

        // 2. Convert the list of entities into a list of DTOs
        return providersFromDb.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    private ProviderDto convertToDto(Provider provider) {
        ProviderDto dto = new ProviderDto();
        dto.setId(provider.getId());
        dto.setName(provider.getName());
        dto.setCity(provider.getCity());
        dto.setCategory(provider.getCategory());
        dto.setSubscribed(provider.isSubscribed());
        dto.setCountry(provider.getCountry());
        dto.setDayName(provider.getDayName());
        dto.setEmail(provider.getEmail());
        dto.setEndOfWork(provider.getEndOfWork());
        dto.setPhone(provider.getPhone());
        dto.setStartOfWork(provider.getStartOfWork());
        dto.setEndOfWork(provider.getEndOfWork());
        dto.setState(provider.getState());
        dto.setStatus(provider.getStatus());
        return dto;
    }
    public ProviderDto approveProvider(Integer providerId) {
        // 1. Find the provider
        Provider provider = providerRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found with id: " + providerId));

        // 2. Update the status
        provider.setStatus("ACTIVE");

        // 3. Save the updated provider
        Provider savedProvider = providerRepository.save(provider);

        // 4. Convert the final result to a DTO and return it
        return convertToDto(savedProvider);
    }

    public List<ProviderDto> getPendingProviders() {
        // 1. Find all providers with "PENDING" status
        List<Provider> pendingProviders = providerRepository.findByStatus("PENDING");

        // 2. Convert the list to DTOs and return it
        return pendingProviders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    public void updateSubscriptionStatus(Integer providerId, boolean isSubscribed) {
        Provider provider = providerRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        provider.setSubscribed(isSubscribed);
        providerRepository.save(provider);
    }
    public List<Provider> getAllProviders() {
        return this.providerRepository.findAll();
    }
    public Provider getItemById(Integer id) {
        return this.providerRepository.findById(id).get();
    }
    public Provider AddProvider(Provider provider) {
        return this.providerRepository.save(provider);
    }
}


//    public Provider approveProvider(Integer providerId) {
//        Provider provider = providerRepository.findById(providerId)
//                .orElseThrow(() -> new RuntimeException("Provider not found"));
//        provider.setStatus("ACTIVE");
//        return providerRepository.save(provider);
//    }
