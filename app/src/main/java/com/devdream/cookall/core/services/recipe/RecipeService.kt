package com.devdream.cookall.core.services.recipe

import com.devdream.cookall.core.listeners.OnRecipeFetchedListener

interface RecipeService {

    fun getAllRecipes(onRecipeFetchedListener: OnRecipeFetchedListener)

}
