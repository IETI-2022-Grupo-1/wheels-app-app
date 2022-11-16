package com.example.wheelsapp.entities.api_responses

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("token") val tokenAuth: String,
    @SerializedName("expirationDate") val date: String
)