package com.devdream.cookall.main;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.devdream.cookall.R;
import com.devdream.cookall.main.favoriterecipes.BottomMenuSelectedListener;
import com.devdream.cookall.main.favoriterecipes.FavoriteRecipeItemFragment;
import com.devdream.cookall.main.favoriterecipes.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements FavoriteRecipeItemFragment.OnListFragmentInteractionListener {

    private BottomNavigationView bottomNavigationView;
    private BottomMenuSelectedListener bottomMenuSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disableBackButton();

        bottomMenuSelectedListener = new BottomMenuSelectedListener(this);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomMenuSelectedListener);

        // TODO Refactor
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new FavoriteRecipeItemFragment(), FavoriteRecipeItemFragment.TAG)
                .commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Log.d("MEW", "Clicked on list item!!");
    }

    private void disableBackButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

}
