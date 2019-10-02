package com.devdream.cookall.main

import com.devdream.cookall.core.dto.RecipeDTO

import java.util.ArrayList
import java.util.HashMap

object DummyListContent {

    val ITEMS: MutableList<RecipeDTO> = ArrayList()

    val ITEM_MAP: MutableMap<Long, RecipeDTO> = HashMap()

    private val COUNT = 10

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(recipe: RecipeDTO) {
        ITEMS.add(recipe)
        ITEM_MAP[recipe.id] = recipe
    }

    private fun createDummyItem(position: Int): RecipeDTO {
        val recipe = RecipeDTO()
        recipe.id = position.toLong()
        recipe.title = "Details about Item: $position"
        return recipe
    }

}
