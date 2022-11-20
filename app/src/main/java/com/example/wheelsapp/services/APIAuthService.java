package com.example.wheelsapp.services;

import com.example.wheelsapp.entities.api_request.UserRequest;
import com.example.wheelsapp.entities.api_responses.AuthResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIAuthService {

    @POST("auth")
    Call<AuthResponse> login(@Body UserRequest  login);
}