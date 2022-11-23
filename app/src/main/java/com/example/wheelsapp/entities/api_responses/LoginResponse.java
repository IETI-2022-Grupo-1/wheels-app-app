package com.example.wheelsapp.entities.api_responses;

import java.util.*;

public class LoginResponse {

    private String token;
    private Date expirationDate;

    public LoginResponse(String token, Date expirationDate) {
        this.token = token;
        this.expirationDate = expirationDate;
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