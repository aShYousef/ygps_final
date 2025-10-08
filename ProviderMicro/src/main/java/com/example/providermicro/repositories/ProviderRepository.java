package com.example.providermicro.repositories;


import com.example.providermicro.models.Provider;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {
    List<Provider> findByCityAndCategoryAndStatusIgnoreCaseOrderByIsSubscribedDesc(
            String city,
            String category,
            String status
    );
    List<Provider> findByStatus(String status);
    @Modifying
    @Transactional
    @Query("UPDATE Provider p SET p.status = :newStatus WHERE p.id = :providerId")
    void updateProviderStatus(@Param("providerId") Long providerId, @Param("newStatus") String newStatus);
}
