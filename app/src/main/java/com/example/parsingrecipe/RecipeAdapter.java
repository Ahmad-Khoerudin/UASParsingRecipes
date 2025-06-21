package com.example.parsingrecipe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private final List<DataRecipes> recipes;
    private final Context context;

    public RecipeAdapter(Context context, List<DataRecipes> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_recipes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataRecipes recipe = recipes.get(position);

        holder.tvName.setText(recipe.getName());
        holder.tvCuisine.setText("Cuisine: " + recipe.getCuisine());
        holder.tvDifficulty.setText("Difficulty: " + recipe.getDifficulty());

        Glide.with(holder.itemView.getContext())
                .load(recipe.getImage())
                .into(holder.ivImage);

        holder.btnDetail.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_RECIPE, recipe);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvName, tvCuisine, tvDifficulty;
        Button btnDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_recipe_image);
            tvName = itemView.findViewById(R.id.tv_recipe_name);
            tvCuisine = itemView.findViewById(R.id.tv_recipe_cuisine);
            tvDifficulty = itemView.findViewById(R.id.tv_recipe_difficulty);
            btnDetail = itemView.findViewById(R.id.btn_detail);
        }
    }
}