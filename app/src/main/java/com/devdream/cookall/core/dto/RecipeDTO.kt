package com.devdream.cookall.core.dto

import java.util.Date

class RecipeDTO {

    var id: Long = 0
    var profileId: Long = 0
    var title: String? = null
    var description: String? = null
    var cookingTime: String? = null
    var calories: Float = 0.toFloat()
    var likes: Long = 0
    var favorites: Long = 0
    var createdAt: Date? = null

}
