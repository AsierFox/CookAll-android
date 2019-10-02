package com.devdream.cookall.main

import android.view.View
import android.widget.Toast

import com.devdream.cookall.core.interactors.RecipeInteractor

class MainPresenter(private val mainActivity: MainActivity) : MainListener {

    private val recipeInteractor: RecipeInteractor

    init {
        recipeInteractor = RecipeInteractor()
    }

    override fun shareRecipe(view: View) {
        Toast.makeText(mainActivity, "Shared!", Toast.LENGTH_SHORT).show()
    }

    override fun likeRecipe(view: View) {
        Toast.makeText(mainActivity, "Liked!", Toast.LENGTH_SHORT).show()
    }

    override fun favoriteRecipe(view: View) {
        Toast.makeText(mainActivity, "Favorited!", Toast.LENGTH_SHORT).show()
    }

}
