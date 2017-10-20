package com.devdream.cookall.core.mapper;

import com.devdream.cookall.core.api.responses.RecipeListResponse;
import com.devdream.cookall.core.dto.RecipeDTO;

import java.util.ArrayList;
import java.util.List;

public abstract class RecipeMapper {

    public static List<RecipeDTO> recipeListResponseToRecipeListDTO(
            List<RecipeListResponse> recipesListResponse) {
        List<RecipeDTO> recipes = new ArrayList<RecipeDTO>();

        for (RecipeListResponse recipeListResponse : recipesListResponse) {
            RecipeDTO recipe = new RecipeDTO();

            recipe.id = recipeListResponse.getId();
            recipe.profileId = recipeListResponse.getProfileId();
            recipe.title = recipeListResponse.getTitle();
            recipe.description = recipeListResponse.getDescription();
            recipe.cookingTime = recipeListResponse.getCookingTime();
            recipe.calories = recipeListResponse.getCalories();
            recipe.likes = recipeListResponse.getLikes();
            recipe.favorites = recipeListResponse.getFavorites();

            recipes.add(recipe);
        }
        return recipes;
    }

}
