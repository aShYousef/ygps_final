package com.example.admin.models;

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

    public Integer getId() {
        return id;
    }

    private boolean isSubscribed;

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




    public void setId(Integer id) {
        this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public boolean isSubscribed() { return isSubscribed; }
    public void setSubscribed(boolean subscribed) { isSubscribed = subscribed; }
}
