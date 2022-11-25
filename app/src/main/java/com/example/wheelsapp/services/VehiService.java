package com.example.wheelsapp.services;

import com.example.wheelsapp.entities.api_request.VehiRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface VehiService {
    @POST("vehicles")
    Call<VehiRequest> createVehi(@Body VehiRequest vehi, @Header("Authorization") String authHeader);
}
