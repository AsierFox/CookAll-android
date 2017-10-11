package com.devdream.cookall.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;

import com.devdream.cookall.R;
import com.devdream.cookall.main.MainActivity;
import com.devdream.cookall.main.favoriterecipes.FavoriteRecipeItemFragment;

public class BottomMenuSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {

    private MainActivity mainActivity;

    public BottomMenuSelectedListener(MainActivity _mainActivity) {
        mainActivity = _mainActivity;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        final FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();

        // Refactor to method
        switch (item.getItemId()) {
            case R.id.navigation_home:
                if (fragmentManager.findFragmentByTag(FavoriteRecipeItemFragment.TAG) == null) {
                    fragmentManager.beginTransaction()
                            .add(R.id.fragment_container, new FavoriteRecipeItemFragment(), FavoriteRecipeItemFragment.TAG)
                            .commit();
                }
                return true;
            case R.id.navigation_dashboard:

                return true;
            case R.id.navigation_notifications:

                return true;
        }

//        fragmentTransaction.disallowAddToBackStack();

        return false;
    }

}
