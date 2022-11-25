package com.example.wheelsapp.entities.api_request;

public class UserRequest {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Integer phoneNumber;
    private String city;
    private String organization;
    private String profilePhoto;

    public UserRequest() {}

    public UserRequest(String name, String lastName, String email, String password, Integer phoneNumber, String city, String profilePhoto) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.organization = "631feea0ae8ca16cd15a5b12";
        this.profilePhoto = profilePhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}
