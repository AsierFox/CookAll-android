package com.devdream.cookall.core.services;

import android.util.Log;

import com.devdream.cookall.core.api.APIRestClient;
import com.devdream.cookall.core.context.AppContext;
import com.devdream.cookall.core.realm.entities.RecipeRealm;
import com.devdream.cookall.core.services.api.RecipeAPIService;
import com.devdream.cookall.core.utils.ConnectivityUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeService {

    public List<RecipeRealm> getAllRecipes() {

        if (ConnectivityUtil.isConnected(AppContext.context)) {

            RecipeAPIService recipeAPIService = APIRestClient.getClient()
                    .create(RecipeAPIService.class);

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
        else {
            // Realm call
        }

        return null;
    }

}
