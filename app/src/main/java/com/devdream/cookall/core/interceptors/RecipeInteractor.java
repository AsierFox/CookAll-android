package com.devdream.cookall.core.interceptors;

import com.devdream.cookall.core.context.AppContext;
import com.devdream.cookall.core.services.api.RecipeAPIService;
import com.devdream.cookall.core.utils.ConnectivityUtil;

public class RecipeInteractor {

    private RecipeAPIService recipeAPIService;

    public RecipeInteractor() {
        recipeAPIService = new RecipeAPIService();
    }

    public void getAllRecipes() {

        if (ConnectivityUtil.isConnected(AppContext.context)) {
            recipeAPIService.getAllRecipes();
        }
        else {
            // TODO call Realm
        }
    }

}
