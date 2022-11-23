package com.example.wheelsapp.services;

import com.example.wheelsapp.entities.api_responses.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface UserService {

    @GET("users/{id}")
    Call<UserResponse> getUser(@Path("id") String id, @Header("Authorization") String authHeader);
}
