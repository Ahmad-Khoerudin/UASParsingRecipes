package com.example.parsingrecipe;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DataRecipes implements Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("ingredients")
    private List<String> ingredients;

    @SerializedName("instructions")
    private List<String> instructions;

    @SerializedName("prepTimeMinutes")
    private int prepTimeMinutes;

    @SerializedName("cookTimeMinutes")
    private int cookTimeMinutes;

    @SerializedName("servings")
    private int servings;

    @SerializedName("difficulty")
    private String difficulty;

    @SerializedName("cuisine")
    private String cuisine;

    @SerializedName("caloriesPerServing")
    private int caloriesPerServing;

    @SerializedName("tags")
    private List<String> tags;

    @SerializedName("image")
    private String image;

    @SerializedName("rating")
    private double rating;

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public List<String> getIngredients() { return ingredients; }
    public List<String> getInstructions() { return instructions; }
    public int getPrepTimeMinutes() { return prepTimeMinutes; }
    public int getCookTimeMinutes() { return cookTimeMinutes; }
    public int getServings() { return servings; }
    public String getDifficulty() { return difficulty; }
    public String getCuisine() { return cuisine; }
    public int getCaloriesPerServing() { return caloriesPerServing; }
    public List<String> getTags() { return tags; }
    public String getImage() { return image; }
    public double getRating() { return rating; }

    // Parcelable Implementation
    protected DataRecipes(Parcel in) {
        id = in.readInt();
        name = in.readString();
        ingredients = in.createStringArrayList();
        instructions = in.createStringArrayList();
        prepTimeMinutes = in.readInt();
        cookTimeMinutes = in.readInt();
        servings = in.readInt();
        difficulty = in.readString();
        cuisine = in.readString();
        caloriesPerServing = in.readInt();
        tags = in.createStringArrayList();
        image = in.readString();
        rating = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeStringList(ingredients);
        dest.writeStringList(instructions);
        dest.writeInt(prepTimeMinutes);
        dest.writeInt(cookTimeMinutes);
        dest.writeInt(servings);
        dest.writeString(difficulty);
        dest.writeString(cuisine);
        dest.writeInt(caloriesPerServing);
        dest.writeStringList(tags);
        dest.writeString(image);
        dest.writeDouble(rating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataRecipes> CREATOR = new Creator<DataRecipes>() {
        @Override
        public DataRecipes createFromParcel(Parcel in) {
            return new DataRecipes(in);
        }

        @Override
        public DataRecipes[] newArray(int size) {
            return new DataRecipes[size];
        }
    };
}