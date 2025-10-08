package com.example.subscriptionandbilling.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionAndBilling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer providerId;
    private String plan; // e.g., "PREMIUM"
    private String status; // e.g., "ACTIVE"
    private LocalDate startDate;
    private LocalDate endDate;
}