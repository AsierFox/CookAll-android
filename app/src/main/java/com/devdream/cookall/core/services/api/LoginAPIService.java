package com.devdream.cookall.core.services.api;

import com.devdream.cookall.core.api.APIRestClient;
import com.devdream.cookall.core.api.responses.LoginAuthResponse;
import com.devdream.cookall.core.dto.LoginAuthDTO;
import com.devdream.cookall.core.dto.UserAuthDTO;
import com.devdream.cookall.core.listeners.OnLoginFetchedListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginAPIService {

    public void login(UserAuthDTO userDTO, final OnLoginFetchedListener onLoginFinishedListener) {

        LoginRetrofitService loginAPIService = APIRestClient.getClient()
                .create(LoginRetrofitService.class);

        Call<LoginAuthResponse> call = loginAPIService.login(userDTO.email, userDTO.password);
        Callback<LoginAuthResponse> callback = new Callback<LoginAuthResponse>() {

            @Override
            public void onResponse(Call<LoginAuthResponse> call, Response<LoginAuthResponse> response) {

                if (response.body() != null && response.body().getCode() == 200) {

                    LoginAuthDTO loginAuthDTO = new LoginAuthDTO();

                    onLoginFinishedListener.onLoginSuccess(loginAuthDTO);
                }
                else {
                    onLoginFinishedListener.onLoginFailure();
                }
            }

            @Override
            public void onFailure(Call<LoginAuthResponse> call, Throwable t) {
                onLoginFinishedListener.onLoginFailure();
            }
        };

        call.enqueue(callback);
    }

}
