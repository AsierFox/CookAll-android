package com.devdream.cookall.core.services;

import android.util.Log;

import com.devdream.cookall.core.api.APIRestClient;
import com.devdream.cookall.core.api.responses.LoginAuthResponse;
import com.devdream.cookall.core.context.AppContext;
import com.devdream.cookall.core.dto.UserAuthDTO;
import com.devdream.cookall.core.exceptions.AuthException;
import com.devdream.cookall.core.services.api.LoginAPIService;
import com.devdream.cookall.core.utils.ConnectivityUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginService {

    public void login(UserAuthDTO userDTO) throws AuthException {

        if (ConnectivityUtil.isConnected(AppContext.getContext())) {

            LoginAPIService loginAPIService = APIRestClient.getClient()
                    .create(LoginAPIService.class);

            Call<LoginAuthResponse> call = loginAPIService.login(userDTO.getEmail(), userDTO.getPassword());

            try {
                call.enqueue(new Callback<LoginAuthResponse>() {

                    @Override
                    public void onResponse(Call<LoginAuthResponse> call, Response<LoginAuthResponse> response) {
                        Log.d("MEW", "Total number of questions fetched : " + response.body());
                    }

                    @Override
                    public void onFailure(Call<LoginAuthResponse> call, Throwable t) {
                        // TODO Throw exception
                    }
                });
            }
            catch (Exception err) {
                throw new AuthException();
            }
        }
        else {
            // Realm call
        }

    }
}
