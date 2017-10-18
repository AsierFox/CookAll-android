package com.devdream.cookall.core.services;

import com.devdream.cookall.core.api.APIRestClient;
import com.devdream.cookall.core.api.responses.LoginAuthResponse;
import com.devdream.cookall.core.context.AppContext;
import com.devdream.cookall.core.dto.UserAuthDTO;
import com.devdream.cookall.core.services.api.LoginAPIService;
import com.devdream.cookall.core.utils.ConnectivityUtil;
import com.devdream.cookall.login.OnLoginFinishedListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginService {

    public void login(UserAuthDTO userDTO, final OnLoginFinishedListener onLoginFinishedListener) {

        if (ConnectivityUtil.isConnected(AppContext.getContext())) {

            LoginAPIService loginAPIService = APIRestClient.getClient()
                    .create(LoginAPIService.class);

            Call<LoginAuthResponse> call = loginAPIService.login(userDTO.getEmail(), userDTO.getPassword());
            Callback<LoginAuthResponse> callback = new Callback<LoginAuthResponse>() {

                @Override
                public void onResponse(Call<LoginAuthResponse> call, Response<LoginAuthResponse> response) {

                    if (response.body() != null && response.body().getCode() == 200) {
                        onLoginFinishedListener.onLoginSuccess();
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
        else {
            // TODO Throw Connection exception
        }
    }

}
