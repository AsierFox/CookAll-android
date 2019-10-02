package com.devdream.cookall.main

import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import android.view.MenuItem

import com.devdream.cookall.R
import com.devdream.cookall.main.explore.ExploreRecipesFragment
import com.devdream.cookall.main.favorites.FavoriteRecipesFragment
import com.devdream.cookall.main.mine.MyRecipesFragment

class BottomMenuSelectedListener(private val mainActivity: MainActivity) : BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val fragmentManager = mainActivity.supportFragmentManager

        val transaction = fragmentManager.beginTransaction()

        // Refactor to method
        when (item.itemId) {
            R.id.favorite_recipes_list -> {
                if (fragmentManager.findFragmentByTag(FavoriteRecipesFragment.TAG) == null) {
                    transaction.add(R.id.fragment_container,
                            mainActivity.favoriteRecipesFragment,
                            FavoriteRecipesFragment.TAG)
                }

                transaction.replace(R.id.fragment_container, mainActivity.favoriteRecipesFragment)

                transaction.addToBackStack(null)
                transaction.commit()

                return true
            }
            R.id.navigation_dashboard -> {
                if (fragmentManager.findFragmentByTag(ExploreRecipesFragment.TAG) == null) {
                    transaction.add(R.id.fragment_container,
                            mainActivity.exploreRecipesFragment,
                            ExploreRecipesFragment.TAG)
                }

                transaction.replace(R.id.fragment_container, mainActivity.exploreRecipesFragment)

                transaction.addToBackStack(null)
                transaction.commit()

                return true
            }
            R.id.navigation_notifications -> {
                if (fragmentManager.findFragmentByTag(MyRecipesFragment.TAG) == null) {
                    transaction.add(R.id.fragment_container,
                            mainActivity.myRecipesFragment,
                            MyRecipesFragment.TAG)
                }

                transaction.replace(R.id.fragment_container, mainActivity.myRecipesFragment)

                transaction.addToBackStack(null)
                transaction.commit()

                return true
            }
        }

        return false
    }

}
