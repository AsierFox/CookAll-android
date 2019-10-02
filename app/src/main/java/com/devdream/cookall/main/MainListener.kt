package com.devdream.cookall.main

import android.view.View

interface MainListener {

    fun shareRecipe(view: View)
    fun likeRecipe(view: View)
    fun favoriteRecipe(view: View)

}
