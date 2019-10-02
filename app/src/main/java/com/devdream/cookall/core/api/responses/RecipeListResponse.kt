package com.devdream.cookall.core.api.responses

import com.google.gson.annotations.SerializedName

class RecipeListResponse : BaseResponse<List<RecipeListResponse>>() {

    @SerializedName("id")
    var id: Long? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("cookingTime")
    var cookingTime: String? = null

    @SerializedName("calories")
    var calories: Float? = null

    @SerializedName("likes")
    var likes: Long? = null

    @SerializedName("favorites")
    var favorites: Long? = null

    @SerializedName("profileId")
    var profileId: Long? = null

}
