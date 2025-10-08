package com.example.subscriptionandbilling.models;

public class ProviderDto {

    private Integer id;
    private String name;
    private String city;
    private String category;
    private String email;
    private String phone;
    private String state;
    private String country;
    private String dayName;
    private double startOfWork;
    private double endOfWork;
    private boolean isSubscribed;
    private String status;

    public Integer getId() {
        return id;
    }

    public ProviderDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProviderDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ProviderDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProviderDto setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public ProviderDto setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getDayName() {
        return dayName;
    }

    public ProviderDto setDayName(String dayName) {
        this.dayName = dayName;
        return this;
    }

    public double getStartOfWork() {
        return startOfWork;
    }

    public ProviderDto setStartOfWork(double startOfWork) {
        this.startOfWork = startOfWork;
        return this;
    }

    public double getEndOfWork() {
        return endOfWork;
    }

    public ProviderDto setEndOfWork(double endOfWork) {
        this.endOfWork = endOfWork;
        return this;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public ProviderDto setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ProviderDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ProviderDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ProviderDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getState() {
        return state;
    }

    public ProviderDto setState(String state) {
        this.state = state;
        return this;
    }
}
