package com.devdream.cookall.core.services.recipe;

import android.util.Log;

import com.devdream.cookall.core.api.APIRestClient;
import com.devdream.cookall.core.api.responses.RecipeListResponse;
import com.devdream.cookall.core.listeners.OnRecipeFetchedListener;
import com.devdream.cookall.core.mapper.RecipeMapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeAPIService implements RecipeService {

    public void getAllRecipes(final OnRecipeFetchedListener onRecipeFetchedListener) {

        RecipeRetrofitService recipeAPIService = APIRestClient.getClient()
                .create(RecipeRetrofitService.class);

        Call<RecipeListResponse> call = recipeAPIService.fetchAllRecipes();

        call.enqueue(new Callback<RecipeListResponse>() {

            @Override
            public void onResponse(Call<RecipeListResponse> call, Response<RecipeListResponse> response) {
                if (response.body() != null && response.body().getCode() == 200) {
                    onRecipeFetchedListener.onGetAllRecipesSuccess(
                                    RecipeMapper.recipeListResponseToRecipeListDTO(
                                            response.body().getData()));
                }
                else {
                    Log.e("MEW", "Null response!");
                }
            }

            @Override
            public void onFailure(Call<RecipeListResponse> call, Throwable t) {
                Log.e("MEW", "Got error : " + t.getLocalizedMessage());
            }
        });

    }

}
