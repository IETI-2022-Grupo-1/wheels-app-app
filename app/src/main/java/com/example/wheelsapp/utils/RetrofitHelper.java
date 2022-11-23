package com.example.wheelsapp.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    static String baseUrl = "https://wheelsapp-dev.herokuapp.com/api/v1/";
    //static String baseUrl = "http://192.168.137.1:8081/api/v1/";

    public static Retrofit getInstance(){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}