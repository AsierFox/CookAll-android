package com.devdream.cookall.modules.recipe

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.devdream.cookall.common.dto.RecipeDTO
import com.devdream.cookall.context.AppContext
import com.example.cookall.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class RecipeListMainActivity : AppCompatActivity(), RecipeListMainContract.OnListFragmentInteractionListener {

    lateinit var bottomNavigationView: BottomNavigationView

//    var favoriteRecipesFragment: FavoriteRecipesFragment? = null
//    var exploreRecipesFragment: ExploreRecipesFragment? = null
//    var myRecipesFragment: MyRecipesFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list_main)

        disableBackButton()

//        favoriteRecipesFragment = FavoriteRecipesFragment()
//        exploreRecipesFragment = ExploreRecipesFragment()
//        myRecipesFragment = MyRecipesFragment()

        bottomNavigationView = findViewById<View>(R.id.bottom_navigation_recipe_list) as BottomNavigationView

        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_recipe_list_main) as NavHostFragment

        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.navController);
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.menu_action_bar_main, menu)
//
//        // Associate searchable configuration with the SearchView
//        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
//        val searchView = menu.findItem(R.id.search_recipes).actionView as SearchView
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
//
//        return true
//    }

//    override fun onListFragmentInteraction(item: RecipeDTO) {
//        val intent = Intent(this, RecipeDetailActivity::class.java)
//        startActivity(intent)
//    }
//
//    override fun onFragmentInteraction(uri: Uri) {}
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        when (item.itemId) {
//            R.id.filter_recipes -> {
//                val dialogBuilder = AlertDialog.Builder(this)
//
//                dialogBuilder.setView(
//                    layoutInflater.inflate(
//                        R.layout.dialog_search_recipes_filter, null))
//                    .setPositiveButton(R.string.filter) { dialog, id ->
//                        // TODO Filter recipes
//                    }
//                    .setNegativeButton(R.string.cancel) { dialog, id -> dialog.cancel() }
//
//                dialogBuilder.create().show()
//                return true
//            }
//            R.id.cookers_ranking -> {
//                startActivity(Intent(this, CookersRankingActivity::class.java))
//                return true
//            }
//            R.id.create_new_recipe -> {
//                startActivity(Intent(this, CreateRecipeActivity::class.java))
//                return true
//            }
//            R.id.profile -> {
//                startActivity(Intent(this, UserProfileActivity::class.java))
//                return true
//            }
//            R.id.settings -> {
//                startActivity(Intent(this, SettingsActivity::class.java))
//                return true
//            }
//        }
//        return false
//    }

    private fun disableBackButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    fun logout(item: MenuItem) {
//        startActivity(Intent(this, LoginActivity::class.java))
//        finish()
    }

    fun test(item: MenuItem) {
//        startActivity(Intent(this, TestActivity::class.java))
    }

    fun navigateFeedback(item: MenuItem) {
//        startActivity(Intent(this, FeedbackActivity::class.java))
    }

    override fun onListFragmentInteraction(item: RecipeDTO?) {
        Toast.makeText(AppContext.applicationContext(), "CLICKED!", Toast.LENGTH_LONG).show()
    }

}
