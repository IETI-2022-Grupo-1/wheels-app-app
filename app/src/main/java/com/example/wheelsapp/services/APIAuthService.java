package com.example.wheelsapp.services;

import static com.example.wheelsapp.LaunchActivity.TOKEN_KEY;

import com.example.wheelsapp.MainActivity2;
import com.example.wheelsapp.entities.api_request.LoginRequest;
import com.example.wheelsapp.entities.api_responses.LoginResponse;
import com.example.wheelsapp.entities.api_responses.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIAuthService {

    @POST("auth")
    Call<LoginResponse> login(@Body LoginRequest login);
}