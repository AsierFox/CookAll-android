package com.devdream.cookall.main.explore;

import com.devdream.cookall.core.dto.RecipeDTO;
import com.devdream.cookall.core.interactors.RecipeInteractor;
import com.devdream.cookall.core.listeners.OnRecipeFetchedListener;

import java.util.List;

public class ExploreRecipesPresenter implements ExploreRecipesListener, OnRecipeFetchedListener {

    private ExploreRecipesListener exploreRecipesListener;
    private RecipeInteractor recipeInteractor;

    private List<RecipeDTO> recipes;

    public ExploreRecipesPresenter(ExploreRecipesListener _exploreRecipesListener) {
        exploreRecipesListener = _exploreRecipesListener;
        recipeInteractor = new RecipeInteractor();
    }

    public void getAllRecipes() {
        recipeInteractor.getAllRecipes(this);
    }

    @Override
    public void onGetAllRecipesSuccess(List<RecipeDTO> recipes) {
        recipesLoaded(recipes);
    }

    @Override
    public void recipesLoaded(List<RecipeDTO> recipes) {
        exploreRecipesListener.recipesLoaded(recipes);
    }

}
