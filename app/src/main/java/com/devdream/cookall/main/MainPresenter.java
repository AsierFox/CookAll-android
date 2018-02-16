package com.devdream.cookall.main;

import android.view.View;
import android.widget.Toast;

import com.devdream.cookall.core.interactors.RecipeInteractor;

public class MainPresenter implements MainListener {

    private MainActivity mainActivity;

    private RecipeInteractor recipeInteractor;

    public MainPresenter(MainActivity _mainActivity) {
        mainActivity = _mainActivity;
        recipeInteractor = new RecipeInteractor();
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

}
