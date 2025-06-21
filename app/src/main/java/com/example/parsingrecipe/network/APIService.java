package com.example.parsingrecipe;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("recipes")
    Call<com.example.parsingrecipe.ResponseRecipes> getRecipes();
}