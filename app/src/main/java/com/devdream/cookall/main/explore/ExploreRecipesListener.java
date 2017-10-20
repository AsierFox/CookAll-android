package com.devdream.cookall.main.explore;

import com.devdream.cookall.core.dto.RecipeDTO;

import java.util.List;

interface ExploreRecipesListener {

    void recipesLoaded(List<RecipeDTO> recipes);

}
