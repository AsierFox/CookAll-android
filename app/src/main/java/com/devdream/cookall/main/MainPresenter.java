package com.devdream.cookall.main;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.devdream.cookall.core.api.APIRestClient;
import com.devdream.cookall.core.models.Recipe;
import com.devdream.cookall.core.services.api.RecipeAPIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainListener {

    private MainActivity mainActivity;

    public MainPresenter(MainActivity _mainActivity) {
        mainActivity = _mainActivity;

        getAllRecipes();
    }

    @Override
    public void shareRecipe(View view) {
        Toast.makeText(mainActivity, "Shared!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void likeRecipe(View view) {
        Toast.makeText(mainActivity, "Liked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void favoriteRecipe(View view) {
        Toast.makeText(mainActivity, "Favorited!", Toast.LENGTH_SHORT).show();
    }

    private void getAllRecipes() {

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

}
