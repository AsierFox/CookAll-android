package com.devdream.cookall.core.api

import com.devdream.cookall.core.utils.Constants

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIRestClient {

    private var retrofit: Retrofit? = null

    val client: Retrofit
        get() {
            if (null == retrofit) {
                retrofit = Retrofit.Builder()
                        .baseUrl(Constants.API.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit
        }

}
