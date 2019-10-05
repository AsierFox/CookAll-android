package com.devdream.cookall.core.services.login

import com.devdream.cookall.core.api.APIRestClient
import com.devdream.cookall.core.api.responses.LoginAuthResponse
import com.devdream.cookall.core.dto.LoginAuthDTO
import com.devdream.cookall.core.dto.UserAuthDTO
import com.devdream.cookall.core.listeners.OnLoginFetchedListener

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginAPIService : LoginService {

    override fun login(userDTO: UserAuthDTO, onLoginFinishedListener: OnLoginFetchedListener) {

        val loginAPIService = APIRestClient.client
                .create(LoginRetrofitService::class.java)

        val call = loginAPIService.login(userDTO.email as String, userDTO.password as String)

        val callback = object : Callback<LoginAuthResponse> {

            override fun onResponse(call: Call<LoginAuthResponse>, response: Response<LoginAuthResponse>) {

                if (response.body() != null && response.body()!!.code == 200) {

                    val loginAuthDTO = LoginAuthDTO()

                    onLoginFinishedListener.onLoginSuccess(loginAuthDTO)
                } else {
                    onLoginFinishedListener.onLoginFailure()
                }
            }

            override fun onFailure(call: Call<LoginAuthResponse>, t: Throwable) {
                onLoginFinishedListener.onLoginFailure()
            }
        }

        call.enqueue(callback)
    }

}
