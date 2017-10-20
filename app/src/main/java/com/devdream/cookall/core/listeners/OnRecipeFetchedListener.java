package com.devdream.cookall.core.listeners;

import com.devdream.cookall.core.dto.RecipeDTO;

import java.util.List;

public interface OnRecipeFetchedListener {

    void onGetAllRecipesSuccess(List<RecipeDTO> recipes);

}
