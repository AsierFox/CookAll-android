package com.devdream.cookall.core.services;

import com.devdream.cookall.core.models.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecipeAPIService {

    @GET("/api/recipes")
    Call<List<Recipe>> fetchAllRecipes();

}
