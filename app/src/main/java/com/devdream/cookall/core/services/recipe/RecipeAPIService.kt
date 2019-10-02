package com.devdream.cookall.core.services.recipe

import android.util.Log

import com.devdream.cookall.core.api.APIRestClient
import com.devdream.cookall.core.api.responses.RecipeListResponse
import com.devdream.cookall.core.listeners.OnRecipeFetchedListener
import com.devdream.cookall.core.mapper.RecipeMapper

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeAPIService : RecipeService {

    override fun getAllRecipes(onRecipeFetchedListener: OnRecipeFetchedListener) {

        val recipeAPIService = APIRestClient.client
                .create(RecipeRetrofitService::class.java)

        val call = recipeAPIService.fetchAllRecipes()

        call.enqueue(object : Callback<RecipeListResponse> {

            override fun onResponse(call: Call<RecipeListResponse>, response: Response<RecipeListResponse>) {
                if (response.body() != null && response.body()!!.code == 200) {
                    onRecipeFetchedListener.onGetAllRecipesSuccess(
                            RecipeMapper.recipeListResponseToRecipeListDTO(
                                    response.body()!!.data!!))
                } else {
                    Log.e("MEW", "Null response!")
                }
            }

            override fun onFailure(call: Call<RecipeListResponse>, t: Throwable) {
                Log.e("MEW", "Got error : " + t.localizedMessage!!)
            }
        })

    }

}
