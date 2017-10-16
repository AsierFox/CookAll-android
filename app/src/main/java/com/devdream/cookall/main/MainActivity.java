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
import com.devdream.cookall.main.mine.MyRecipesFragment;
import com.devdream.cookall.profile.UserProfileActivity;
import com.devdream.cookall.recipe.create.CreateRecipeActivity;
import com.devdream.cookall.recipe.detail.RecipeDetailActivity;
import com.devdream.cookall.settings.SettingsActivity;

public class MainActivity extends AppCompatActivity implements
        MainListener,
        FavoriteRecipesFragment.OnListFragmentInteractionListener,
        ExploreRecipesFragment.OnFragmentInteractionListener,
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

        // TODO Retrofit call example, refactor to presenter
//        QuestionAPIService apiService = RestClient.getClient().create(QuestionAPIService.class);
//        Call<ArrayList<Recipe>> call = apiService.fetchQuestions("android");
//        call.enqueue(new Callback<QuestionList>() {
//            @Override
//            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
//                Log.d(TAG, "Total number of questions fetched : " + response.body().getQuestions().size());
//            }
//
//            @Override
//            public void onFailure(Call<QuestionList> call, Throwable t) {
//                Log.e(TAG, "Got error : " + t.getLocalizedMessage());
//            }
//        });

        mainPresenter = new MainPresenter(this);
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

}
