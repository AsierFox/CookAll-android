package com.devdream.cookall.core.listeners

import com.devdream.cookall.core.dto.RecipeDTO

interface OnRecipeFetchedListener {

    fun onGetAllRecipesSuccess(recipes: List<RecipeDTO>)

}
