package com.devdream.cookall.main;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.devdream.cookall.R;
import com.devdream.cookall.main.favoriterecipes.BottomMenuSelectedListener;
import com.devdream.cookall.main.favoriterecipes.FavoriteRecipeItemFragment;
import com.devdream.cookall.main.favoriterecipes.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements FavoriteRecipeItemFragment.OnListFragmentInteractionListener {

    private BottomNavigationView bottomNavigationView;
    private BottomMenuSelectedListener bottomMenuSelectedListener;

    private boolean hasActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasActionBar = getSupportActionBar() != null;

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

    private void disableBackButton() {
        if (hasActionBar) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Log.d("MEW", "Clicked on list item!!");
    }

}
