package com.devdream.cookall.main;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.devdream.cookall.R;
import com.devdream.cookall.core.dto.RecipeDTO;
import com.devdream.cookall.feedback.FeedbackActivity;
import com.devdream.cookall.login.LoginActivity;
import com.devdream.cookall.main.explore.ExploreRecipesFragment;
import com.devdream.cookall.main.favorites.FavoriteRecipesFragment;
import com.devdream.cookall.main.mine.MyRecipesFragment;
import com.devdream.cookall.profile.UserProfileActivity;
import com.devdream.cookall.recipe.create.CreateRecipeActivity;
import com.devdream.cookall.recipe.detail.RecipeDetailActivity;
import com.devdream.cookall.settings.SettingsActivity;
import com.devdream.cookall.test.TestActivity;

public class MainActivity extends AppCompatActivity implements
        MainListener,
        FavoriteRecipesFragment.OnListFragmentInteractionListener,
        ExploreRecipesFragment.OnListFragmentInteractionListener,
        MyRecipesFragment.OnFragmentInteractionListener {

    private BottomNavigationView bottomNavigationView;
    private BottomMenuSelectedListener bottomMenuSelectedListener;

    private MainPresenter mainPresenter;

    protected FavoriteRecipesFragment favoriteRecipesFragment;
    protected ExploreRecipesFragment exploreRecipesFragment;
    protected MyRecipesFragment myRecipesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disableBackButton();

        favoriteRecipesFragment = new FavoriteRecipesFragment();
        exploreRecipesFragment = new ExploreRecipesFragment();
        myRecipesFragment = new MyRecipesFragment();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomMenuSelectedListener = new BottomMenuSelectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomMenuSelectedListener);

        // TODO Refactor to BottomMenuSelectedListener
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, favoriteRecipesFragment, FavoriteRecipesFragment.TAG)
                .commit();

        mainPresenter = new MainPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action_bar_main, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search_recipes).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public void onListFragmentInteraction(RecipeDTO item) {
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
                startActivity(new Intent(this, CreateRecipeActivity.class));
                return true;
            case R.id.profile:
                startActivity(new Intent(this, UserProfileActivity.class));
                return true;
            case R.id.settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
        }

        return false;
    }

    @Override
    public void likeRecipe(View view) {
        mainPresenter.likeRecipe(view);
    }

    @Override
    public void shareRecipe(View view) {
        mainPresenter.shareRecipe(view);
    }

    @Override
    public void favoriteRecipe(View view) {
        mainPresenter.favoriteRecipe(view);
    }

    private void disableBackButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void logout(MenuItem item) {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    public void test(MenuItem item) {
        startActivity(new Intent(this, TestActivity.class));
    }

    public void navigateFeedback(MenuItem item) {
        startActivity(new Intent(this, FeedbackActivity.class));
    }
}
