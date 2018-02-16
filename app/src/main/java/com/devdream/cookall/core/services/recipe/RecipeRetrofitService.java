package com.devdream.cookall.core.services.recipe;

import com.devdream.cookall.core.api.responses.RecipeListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

interface RecipeRetrofitService {

    @GET("/recipes")
    Call<RecipeListResponse> fetchAllRecipes();

}
