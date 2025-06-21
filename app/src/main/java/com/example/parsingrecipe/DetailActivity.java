package com.example.parsingrecipe;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_RECIPE = "extra_recipe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        com.example.parsingrecipe.DataRecipes recipe = getIntent().getParcelableExtra(EXTRA_RECIPE);

        ImageView ivDetailImage = findViewById(R.id.iv_detail_image);
        TextView tvDetailName = findViewById(R.id.tv_detail_name);
        TextView tvDetailCuisine = findViewById(R.id.tv_detail_cuisine);
        TextView tvDetailDifficulty = findViewById(R.id.tv_detail_difficulty);
        TextView tvDetailTime = findViewById(R.id.tv_detail_time);
        TextView tvDetailServings = findViewById(R.id.tv_detail_servings);
        TextView tvDetailCalories = findViewById(R.id.tv_detail_calories);
        TextView tvDetailIngredients = findViewById(R.id.tv_detail_ingredients);
        TextView tvDetailInstructions = findViewById(R.id.tv_detail_instructions);

        if (recipe != null) {
            Glide.with(this).load(recipe.getImage()).into(ivDetailImage);
            tvDetailName.setText(recipe.getName());
            tvDetailCuisine.setText("Cuisine: " + recipe.getCuisine());
            tvDetailDifficulty.setText("Difficulty: " + recipe.getDifficulty());
            tvDetailTime.setText("Prep: " + recipe.getPrepTimeMinutes() + "min, Cook: " + recipe.getCookTimeMinutes() + "min");
            tvDetailServings.setText("Servings: " + recipe.getServings());
            tvDetailCalories.setText("Calories: " + recipe.getCaloriesPerServing() + "/serving");

            tvDetailIngredients.setText(formatListToString(recipe.getIngredients(), "- "));
            tvDetailInstructions.setText(formatListToString(recipe.getInstructions(), ""));
        }
    }

    private String formatListToString(List<String> list, String prefix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (prefix.isEmpty()) {
                // For instructions, add numbering
                sb.append(i + 1).append(". ").append(list.get(i)).append("\n\n");
            } else {
                // For ingredients, use prefix (like '-')
                sb.append(prefix).append(list.get(i)).append("\n");
            }
        }
        return sb.toString();
    }
}