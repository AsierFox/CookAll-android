package com.devdream.cookall.core.api.responses

import com.google.gson.annotations.SerializedName

class LoginAuthResponse : BaseResponse<LoginAuthResponse>() {

    @SerializedName("id")
    var token: String? = null

    @SerializedName("userId")
    var userId: Int = 0

}
