package com.devdream.cookall.login;

import com.devdream.cookall.core.dto.LoginAuthDTO;
import com.devdream.cookall.core.dto.UserAuthDTO;
import com.devdream.cookall.core.exceptions.NoNetworkAccessException;
import com.devdream.cookall.core.interceptors.LoginInteractor;

public class LoginPresenter implements LoginListener, OnLoginFinishedListener {

    private LoginActivity loginActivity;
    private LoginInteractor loginInterator;

    public LoginPresenter(LoginActivity _loginActivity) {
        loginActivity = _loginActivity;
        loginInterator = new LoginInteractor();
    }

    public void login(final String email, final String password) {
        startLoginProcess();

        UserAuthDTO userAuthDTO = new UserAuthDTO(email, password);

        try {
            loginInterator.login(userAuthDTO, this);
        }
        catch (NoNetworkAccessException e) {
            // TODO Call error listener exception
        }
    }

    @Override
    public void startLoginProcess() {
        loginActivity.startLoginProcess();
    }

    @Override
    public void successLoginProcess() {
        loginActivity.successLoginProcess();
    }

    @Override
    public void errorLoginProcess() {
        loginActivity.errorLoginProcess();
    }

    @Override
    public void onLoginSuccess(LoginAuthDTO loginAuthDTO) {
        successLoginProcess();
    }

    @Override
    public void onLoginFailure() {
        errorLoginProcess();
    }

}
