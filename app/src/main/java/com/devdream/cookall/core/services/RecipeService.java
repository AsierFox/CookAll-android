package com.devdream.cookall.core.services;

import android.util.Log;

import com.devdream.cookall.core.api.APIRestClient;
import com.devdream.cookall.core.context.AppContext;
import com.devdream.cookall.core.entities.Recipe;
import com.devdream.cookall.core.services.api.RecipeAPIService;
import com.devdream.cookall.core.utils.ConnectivityUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeService {

    public List<Recipe> getAllRecipes() {

        if (ConnectivityUtil.isConnected(AppContext.context)) {

            RecipeAPIService recipeAPIService = APIRestClient.getClient()
                    .create(RecipeAPIService.class);

            Call<List<Recipe>> call = recipeAPIService.fetchAllRecipes();

            call.enqueue(new Callback<List<Recipe>>() {

                @Override
                public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                    Log.d("MEW", "Total number of questions fetched : " + response.body());
                }

                @Override
                public void onFailure(Call<List<Recipe>> call, Throwable t) {
                    Log.e("MEW", "Got error : " + t.getLocalizedMessage());
                }
            });
        }
        else {
            // Realm call
        }

        return null;
    }

}
