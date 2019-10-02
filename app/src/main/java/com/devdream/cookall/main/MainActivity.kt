package com.devdream.cookall.main

import android.app.AlertDialog
import android.app.SearchManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.view.View

import com.devdream.cookall.R
import com.devdream.cookall.core.dto.RecipeDTO
import com.devdream.cookall.feedback.FeedbackActivity
import com.devdream.cookall.login.LoginActivity
import com.devdream.cookall.main.explore.ExploreRecipesFragment
import com.devdream.cookall.main.favorites.FavoriteRecipesFragment
import com.devdream.cookall.main.mine.MyRecipesFragment
import com.devdream.cookall.profile.UserProfileActivity
import com.devdream.cookall.ranking.CookersRankingActivity
import com.devdream.cookall.recipe.create.CreateRecipeActivity
import com.devdream.cookall.recipe.detail.RecipeDetailActivity
import com.devdream.cookall.settings.SettingsActivity
import com.devdream.cookall.test.TestActivity

class MainActivity : AppCompatActivity(), MainListener, FavoriteRecipesFragment.OnListFragmentInteractionListener, ExploreRecipesFragment.OnListFragmentInteractionListener, MyRecipesFragment.OnFragmentInteractionListener {

    private var bottomNavigationView: BottomNavigationView? = null
    private var bottomMenuSelectedListener: BottomMenuSelectedListener? = null

    private var mainPresenter: MainPresenter? = null

    var favoriteRecipesFragment: FavoriteRecipesFragment
    var exploreRecipesFragment: ExploreRecipesFragment
    var myRecipesFragment: MyRecipesFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        disableBackButton()

        favoriteRecipesFragment = FavoriteRecipesFragment()
        exploreRecipesFragment = ExploreRecipesFragment()
        myRecipesFragment = MyRecipesFragment()

        bottomNavigationView = findViewById<View>(R.id.navigation) as BottomNavigationView
        bottomMenuSelectedListener = BottomMenuSelectedListener(this)
        bottomNavigationView!!.setOnNavigationItemSelectedListener(bottomMenuSelectedListener)

        // TODO Refactor to BottomMenuSelectedListener
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, favoriteRecipesFragment, FavoriteRecipesFragment.TAG)
                .commit()

        mainPresenter = MainPresenter(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_action_bar_main, menu)

        // Associate searchable configuration with the SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search_recipes).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        return true
    }

    override fun onListFragmentInteraction(item: RecipeDTO) {
        val intent = Intent(this, RecipeDetailActivity::class.java)
        startActivity(intent)
    }

    override fun onFragmentInteraction(uri: Uri) {}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.filter_recipes -> {
                val dialogBuilder = AlertDialog.Builder(this)

                dialogBuilder.setView(
                        layoutInflater.inflate(
                                R.layout.dialog_search_recipes_filter, null))
                        .setPositiveButton(R.string.filter) { dialog, id ->
                            // TODO Filter recipes
                        }
                        .setNegativeButton(R.string.cancel) { dialog, id -> dialog.cancel() }

                dialogBuilder.create().show()
                return true
            }
            R.id.cookers_ranking -> {
                startActivity(Intent(this, CookersRankingActivity::class.java))
                return true
            }
            R.id.create_new_recipe -> {
                startActivity(Intent(this, CreateRecipeActivity::class.java))
                return true
            }
            R.id.profile -> {
                startActivity(Intent(this, UserProfileActivity::class.java))
                return true
            }
            R.id.settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                return true
            }
        }
        return false
    }

    override fun likeRecipe(view: View) {
        mainPresenter!!.likeRecipe(view)
    }

    override fun shareRecipe(view: View) {
        mainPresenter!!.shareRecipe(view)
    }

    override fun favoriteRecipe(view: View) {
        mainPresenter!!.favoriteRecipe(view)
    }

    private fun disableBackButton() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
    }

    fun logout(item: MenuItem) {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    fun test(item: MenuItem) {
        startActivity(Intent(this, TestActivity::class.java))
    }

    fun navigateFeedback(item: MenuItem) {
        startActivity(Intent(this, FeedbackActivity::class.java))
    }
}
