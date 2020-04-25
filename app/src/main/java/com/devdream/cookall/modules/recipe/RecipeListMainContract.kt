package com.devdream.cookall.modules.recipe

import com.devdream.cookall.common.dto.RecipeDTO

interface RecipeListMainContract {

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: RecipeDTO?)
    }

}
