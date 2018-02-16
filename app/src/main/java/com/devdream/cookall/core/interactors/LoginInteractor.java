package com.devdream.cookall.core.interactors;

import com.devdream.cookall.core.context.AppContext;
import com.devdream.cookall.core.dto.UserAuthDTO;
import com.devdream.cookall.core.exceptions.NoNetworkAccessException;
import com.devdream.cookall.core.listeners.OnLoginFetchedListener;
import com.devdream.cookall.core.services.login.LoginAPIService;
import com.devdream.cookall.core.services.login.LoginService;
import com.devdream.cookall.core.utils.ConnectivityUtil;

public class LoginInteractor {

    private LoginService loginService;

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
