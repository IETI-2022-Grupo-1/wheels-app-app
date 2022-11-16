package com.example.wheelsapp.entities.api_request

import com.google.gson.annotations.SerializedName

data class UserRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)