package com.devdream.cookall.core.services.api;

import com.devdream.cookall.core.entities.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecipeAPIService {

    @GET("/api/recipes")
    Call<List<Recipe>> fetchAllRecipes();

}
