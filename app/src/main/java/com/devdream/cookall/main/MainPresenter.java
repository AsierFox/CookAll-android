package com.devdream.cookall.main;

import android.view.View;
import android.widget.Toast;

public class MainPresenter implements MainListener {

    private MainActivity mainActivity;

    public MainPresenter(MainActivity _mainActivity) {
        mainActivity = _mainActivity;
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
