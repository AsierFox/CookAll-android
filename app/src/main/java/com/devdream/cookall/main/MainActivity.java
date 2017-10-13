package com.devdream.cookall.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.devdream.cookall.R;
import com.devdream.cookall.main.favoriterecipes.FavoriteRecipeItemFragment;
import com.devdream.cookall.main.favoriterecipes.dummy.DummyContent;
import com.devdream.cookall.recipe.create.CreateRecipeActivity;
import com.devdream.cookall.recipe.detail.RecipeDetailActivity;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action_bar_main, menu);
        return true;
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Intent intent = new Intent(this, RecipeDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.create_new_recipe:
                Intent intent = new Intent(this, CreateRecipeActivity.class);
                startActivity(intent);
                return true;
        }

        return false;
    }

    public void likeRecipe(View view) {
        Toast.makeText(this, "Liked!", Toast.LENGTH_SHORT).show();
    }

    public void shareRecipe(View view) {
        Toast.makeText(this, "Shared!", Toast.LENGTH_SHORT).show();
    }

    public void favoriteRecipe(View view) {
        Toast.makeText(this, "Favorited!", Toast.LENGTH_SHORT).show();
    }

    private void disableBackButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

}
