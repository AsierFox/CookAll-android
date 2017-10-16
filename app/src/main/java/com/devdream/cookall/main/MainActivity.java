package com.devdream.cookall.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.devdream.cookall.R;
import com.devdream.cookall.core.models.Recipe;
import com.devdream.cookall.main.explore.ExploreRecipesFragment;
import com.devdream.cookall.main.favorites.FavoriteRecipesFragment;
import com.devdream.cookall.profile.UserProfileActivity;
import com.devdream.cookall.recipe.create.CreateRecipeActivity;
import com.devdream.cookall.recipe.detail.RecipeDetailActivity;
import com.devdream.cookall.settings.SettingsActivity;

public class MainActivity extends AppCompatActivity implements
        FavoriteRecipesFragment.OnListFragmentInteractionListener,
        ExploreRecipesFragment.OnFragmentInteractionListener {

    private BottomNavigationView bottomNavigationView;
    private BottomMenuSelectedListener bottomMenuSelectedListener;

    protected FavoriteRecipesFragment favoriteRecipesFragment;
    protected ExploreRecipesFragment exploreRecipesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disableBackButton();

        favoriteRecipesFragment = new FavoriteRecipesFragment();
        exploreRecipesFragment = new ExploreRecipesFragment();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomMenuSelectedListener = new BottomMenuSelectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomMenuSelectedListener);

        // TODO Refactor to BottomMenuSelectedListener
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, favoriteRecipesFragment, FavoriteRecipesFragment.TAG)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action_bar_main, menu);
        return true;
    }

    @Override
    public void onListFragmentInteraction(Recipe item) {
        Intent intent = new Intent(this, RecipeDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.create_new_recipe:
                Intent newRecipeIntent = new Intent(this, CreateRecipeActivity.class);
                startActivity(newRecipeIntent);
                return true;
            case R.id.profile:
                Intent profileIntent = new Intent(this, UserProfileActivity.class);
                startActivity(profileIntent);
                return true;
            case R.id.settings:
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingsIntent);
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
