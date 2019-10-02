package com.devdream.cookall.core.services.login

import com.devdream.cookall.core.api.responses.LoginAuthResponse

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

internal interface LoginRetrofitService {

    @FormUrlEncoded
    @POST("/auth/login")
    fun login(@Field("email") email: String, @Field("password") password: String): Call<LoginAuthResponse>

}
