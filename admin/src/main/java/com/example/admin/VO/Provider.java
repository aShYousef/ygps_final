package com.example.admin.VO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    @Column(name = "status", columnDefinition = "VARCHAR(255) DEFAULT 'PENDING'")
    private String status;
}