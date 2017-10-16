package com.devdream.cookall.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.MenuItem;

import com.devdream.cookall.R;
import com.devdream.cookall.main.explore.ExploreRecipesFragment;
import com.devdream.cookall.main.favorites.FavoriteRecipesFragment;

public class BottomMenuSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {

    private MainActivity mainActivity;

    public BottomMenuSelectedListener(MainActivity _mainActivity) {
        mainActivity = _mainActivity;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        final FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();

        Log.d("MEW", "Hello world! :D" + item.getItemId());

        // Refactor to method
        switch (item.getItemId()) {
            case R.id.favorite_recipes_list:
                if (fragmentManager.findFragmentByTag(FavoriteRecipesFragment.TAG) == null) {
                    fragmentManager
                            .beginTransaction()
                            .add(R.id.fragment_container,
                                    mainActivity.favoriteRecipesFragment,
                                    FavoriteRecipesFragment.TAG)
                            .commit();
                }

                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container,
                                mainActivity.favoriteRecipesFragment)
                        .commit();
                return true;
            case R.id.navigation_dashboard:
                if (fragmentManager.findFragmentByTag(ExploreRecipesFragment.TAG) == null) {
                    fragmentManager
                            .beginTransaction()
                            .add(R.id.fragment_container,
                                    mainActivity.exploreRecipesFragment,
                                    ExploreRecipesFragment.TAG)
                            .commit();
                }

                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container,
                                mainActivity.exploreRecipesFragment)
                        .commit();
                return true;
            case R.id.navigation_notifications:

                return true;
        }

//        fragmentTransaction.disallowAddToBackStack();

        return false;
    }

}
