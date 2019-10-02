package com.devdream.cookall.core.api.responses

import com.google.gson.annotations.SerializedName

abstract class BaseResponse<T> {

    @SerializedName("code")
    var code: Int = 0

    @SerializedName("status")
    var status: String? = null

    @SerializedName("data")
    var data: T? = null

}
