package com.example.parsingrecipe;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvRecipes;
    private ProgressBar progressBar;
    private RecipeAdapter recipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRecipes = findViewById(R.id.rv_recipes);
        progressBar = findViewById(R.id.progress_bar);

        rvRecipes.setLayoutManager(new LinearLayoutManager(this));

        fetchRecipes();
    }

    private void fetchRecipes() {
        progressBar.setVisibility(View.VISIBLE);

        com.example.parsingrecipe.APIService apiService = com.example.parsingrecipe.APIConfig.getApiService();
        Call<com.example.parsingrecipe.ResponseRecipes> call = apiService.getRecipes();

        call.enqueue(new Callback<com.example.parsingrecipe.ResponseRecipes>() {
            @Override
            public void onResponse(Call<com.example.parsingrecipe.ResponseRecipes> call, Response<com.example.parsingrecipe.ResponseRecipes> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    recipeAdapter = new RecipeAdapter(MainActivity.this, response.body().getRecipes());
                    rvRecipes.setAdapter(recipeAdapter);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<com.example.parsingrecipe.ResponseRecipes> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}