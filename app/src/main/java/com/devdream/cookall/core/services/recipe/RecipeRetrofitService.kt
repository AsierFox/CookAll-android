package com.devdream.cookall.core.services.recipe

import com.devdream.cookall.core.api.responses.RecipeListResponse

import retrofit2.Call
import retrofit2.http.GET

internal interface RecipeRetrofitService {

    @GET("/recipes")
    fun fetchAllRecipes(): Call<RecipeListResponse>

}
