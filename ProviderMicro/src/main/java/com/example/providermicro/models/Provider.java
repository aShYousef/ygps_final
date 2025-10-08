package com.example.providermicro.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provider
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String dayName;
    private double startOfWork;
    private double endOfWork;
    private String category;
    private String status = "PENDING";
    private boolean isSubscribed;
}
