package com.devdream.cookall.core.services.api;

import com.devdream.cookall.core.api.responses.LoginAuthResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

interface LoginRetrofitService {

    @FormUrlEncoded
    @POST("/auth/login")
    Call<LoginAuthResponse> login(@Field("email") String email, @Field("password") String password);

}
