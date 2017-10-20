package com.devdream.cookall.core.interceptors;

import com.devdream.cookall.core.context.AppContext;
import com.devdream.cookall.core.dto.UserAuthDTO;
import com.devdream.cookall.core.exceptions.NoNetworkAccessException;
import com.devdream.cookall.core.listeners.OnLoginFetchedListener;
import com.devdream.cookall.core.services.api.LoginAPIService;
import com.devdream.cookall.core.utils.ConnectivityUtil;

public class LoginInteractor {

    private LoginAPIService loginService;

    public LoginInteractor() {
        loginService = new LoginAPIService();
    }

    public void login(UserAuthDTO userDTO, final OnLoginFetchedListener onLoginFinishedListener)
            throws NoNetworkAccessException {

        if (ConnectivityUtil.isConnected(AppContext.context)) {
            loginService.login(userDTO, onLoginFinishedListener);
        }
        else {
            throw new NoNetworkAccessException();
        }
    }

}
