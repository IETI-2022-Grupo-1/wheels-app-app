package com.example.wheelsapp.services

import com.example.wheelsapp.entities.api_request.UserRequest
import com.example.wheelsapp.entities.api_responses.AuthResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIAuthService {
    @POST("/auth")
    @FormUrlEncoded
    fun getToken(@Body user : UserRequest):Response<AuthResponse>
}