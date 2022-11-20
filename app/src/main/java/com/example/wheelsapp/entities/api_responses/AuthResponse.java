package com.example.wheelsapp.entities.api_responses;

import java.util.*;

public class AuthResponse {

    private String token;
    private Date expirationDate;

    public AuthResponse(String token, Date expirationDate) {
        this.token = token;
        this.expirationDate = expirationDate;
        System.out.println(token+" se esta creando el token");
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}