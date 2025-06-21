package com.example.parsingrecipe;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIConfig {
    private static final String BASE_URL = "https://dummyjson.com/";

    public static com.example.parsingrecipe.APIService getApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(com.example.parsingrecipe.APIService.class);
    }
}