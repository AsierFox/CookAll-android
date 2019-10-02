package com.devdream.cookall.core.mapper

import com.devdream.cookall.core.api.responses.RecipeListResponse
import com.devdream.cookall.core.dto.RecipeDTO

import java.util.ArrayList

object RecipeMapper {

    fun recipeListResponseToRecipeListDTO(
            recipesListResponse: List<RecipeListResponse>): List<RecipeDTO> {
        val recipes = ArrayList<RecipeDTO>()

        for (recipeListResponse in recipesListResponse) {
            val recipe = RecipeDTO()

            recipe.id = recipeListResponse.id!!
            recipe.profileId = recipeListResponse.profileId!!
            recipe.title = recipeListResponse.title
            recipe.description = recipeListResponse.description
            recipe.cookingTime = recipeListResponse.cookingTime
            recipe.calories = recipeListResponse.calories!!
            recipe.likes = recipeListResponse.likes!!
            recipe.favorites = recipeListResponse.favorites!!

            recipes.add(recipe)
        }
        return recipes
    }

}
