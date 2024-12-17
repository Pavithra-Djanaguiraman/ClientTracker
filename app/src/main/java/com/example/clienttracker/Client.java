package com.example.clienttracker;

public class Client {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String membershipType;
    private String membershipEndDate;
    private String upiId;

    // Default constructor for Firebase
    public Client() {}

    public Client(String id, String name, String email, String phone, 
                 String membershipType, String membershipEndDate, String upiId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.membershipType = membershipType;
        this.membershipEndDate = membershipEndDate;
        this.upiId = upiId;
    }

    // Getters and setters
    // ... add standard getters and setters for all fields
}