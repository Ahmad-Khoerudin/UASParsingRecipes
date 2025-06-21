package com.example.parsingrecipe;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ResponseRecipes {

    @SerializedName("recipes")
    private List<com.example.parsingrecipe.DataRecipes> recipes;

    public List<com.example.parsingrecipe.DataRecipes> getRecipes() {
        return recipes;
    }
}