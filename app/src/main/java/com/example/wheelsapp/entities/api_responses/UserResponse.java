package com.example.wheelsapp.entities.api_responses;

import com.example.wheelsapp.utils.RoleEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserResponse {
    private String id;
    private String city;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String organization;
    private String profilePhoto;
    private List<RoleEnum> roles = new ArrayList<>();
    private boolean isActive;

    public UserResponse(String id, String city, String name, String lastName, String email, String password, String phoneNumber, String organization, String profilePhoto, List<RoleEnum> roles, boolean isActive) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.organization = organization;
        this.profilePhoto = profilePhoto;
        this.roles = roles;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
