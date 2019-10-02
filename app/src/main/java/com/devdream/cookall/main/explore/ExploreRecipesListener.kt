package com.devdream.cookall.main.explore

import com.devdream.cookall.core.dto.RecipeDTO

internal interface ExploreRecipesListener {

    fun recipesLoaded(recipes: List<RecipeDTO>)

}
