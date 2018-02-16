package com.devdream.cookall.core.services.recipe;

import com.devdream.cookall.core.listeners.OnRecipeFetchedListener;

public interface RecipeService {

    void getAllRecipes(final OnRecipeFetchedListener onRecipeFetchedListener);

}
