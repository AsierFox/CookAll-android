package com.devdream.cookall.core.interactors

import com.devdream.cookall.core.context.AppContext
import com.devdream.cookall.core.listeners.OnRecipeFetchedListener
import com.devdream.cookall.core.services.recipe.RecipeAPIService
import com.devdream.cookall.core.services.recipe.RecipeService
import com.devdream.cookall.core.utils.ConnectivityUtil

class RecipeInteractor {

    private val recipeService: RecipeService

    init {
        recipeService = RecipeAPIService()
    }

    fun getAllRecipes(onRecipeFetchedListener: OnRecipeFetchedListener) {

        if (ConnectivityUtil.isConnected(AppContext.context)) {
            recipeService.getAllRecipes(onRecipeFetchedListener)
        } else {
            // TODO call Realm
        }
    }

}
