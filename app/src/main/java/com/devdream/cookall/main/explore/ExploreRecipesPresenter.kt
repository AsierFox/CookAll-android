package com.devdream.cookall.main.explore

import com.devdream.cookall.core.dto.RecipeDTO
import com.devdream.cookall.core.interactors.RecipeInteractor
import com.devdream.cookall.core.listeners.OnRecipeFetchedListener

class ExploreRecipesPresenter(private val exploreRecipesListener: ExploreRecipesListener) : ExploreRecipesListener, OnRecipeFetchedListener {
    private val recipeInteractor: RecipeInteractor

    private val recipes: List<RecipeDTO>? = null

    init {
        recipeInteractor = RecipeInteractor()
    }

    fun getAllRecipes() {
        recipeInteractor.getAllRecipes(this)
    }

    override fun onGetAllRecipesSuccess(recipes: List<RecipeDTO>) {
        recipesLoaded(recipes)
    }

    override fun recipesLoaded(recipes: List<RecipeDTO>) {
        exploreRecipesListener.recipesLoaded(recipes)
    }

}
