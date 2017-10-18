package com.devdream.cookall.core.services.api;

import com.devdream.cookall.core.realm.entities.RecipeRealm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecipeAPIService {

    @GET("/api/recipes")
    Call<List<RecipeRealm>> fetchAllRecipes();

}
