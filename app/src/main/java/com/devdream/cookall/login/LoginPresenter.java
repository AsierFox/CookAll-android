package com.devdream.cookall.login;

import com.devdream.cookall.core.dto.LoginAuthDTO;
import com.devdream.cookall.core.dto.UserAuthDTO;
import com.devdream.cookall.core.exceptions.NoNetworkAccessException;
import com.devdream.cookall.core.interactors.LoginInteractor;
import com.devdream.cookall.core.listeners.OnLoginFetchedListener;

public class LoginPresenter implements LoginListener, OnLoginFetchedListener {

    private LoginListener loginListener;
    private LoginInteractor loginInterator;

    public LoginPresenter(LoginListener _loginListener) {
        loginListener = _loginListener;
        loginInterator = new LoginInteractor();
    }

    public void login(final String email, final String password) {
        startLoginProcess();

        UserAuthDTO userAuthDTO = new UserAuthDTO();

        try {
            loginInterator.login(userAuthDTO, this);
        }
        catch (NoNetworkAccessException e) {
            noNetworkAccessError();
        }
    }

    @Override
    public void startLoginProcess() {
        loginListener.startLoginProcess();
    }

    @Override
    public void successLoginProcess() {
        loginListener.successLoginProcess();
    }

    @Override
    public void errorLoginProcess() {
        loginListener.errorLoginProcess();
    }

    @Override
    public void onLoginSuccess(LoginAuthDTO loginAuthDTO) {
        successLoginProcess();
    }

    @Override
    public void onLoginFailure() {
        errorLoginProcess();
    }

    @Override
    public void noNetworkAccessError() {
        loginListener.noNetworkAccessError();
    }

}
