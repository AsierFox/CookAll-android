package com.devdream.cookall.core.services.api;

import android.util.Log;

import com.devdream.cookall.core.api.APIRestClient;
import com.devdream.cookall.core.realm.entities.RecipeRealm;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeAPIService {

    public void getAllRecipes() {

        RecipeRetrofitService recipeAPIService = APIRestClient.getClient()
                .create(RecipeRetrofitService.class);

        Call<List<RecipeRealm>> call = recipeAPIService.fetchAllRecipes();

        call.enqueue(new Callback<List<RecipeRealm>>() {

            @Override
            public void onResponse(Call<List<RecipeRealm>> call, Response<List<RecipeRealm>> response) {
                Log.d("MEW", "Total number of questions fetched : " + response.body());
            }

            @Override
            public void onFailure(Call<List<RecipeRealm>> call, Throwable t) {
                Log.e("MEW", "Got error : " + t.getLocalizedMessage());
            }
        });

    }

}
