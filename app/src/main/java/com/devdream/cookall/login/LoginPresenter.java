package com.devdream.cookall.login;

import com.devdream.cookall.core.dto.UserAuthDTO;
import com.devdream.cookall.core.services.LoginService;

public class LoginPresenter implements LoginListener, OnLoginFinishedListener {

    private LoginActivity loginActivity;
    private LoginService loginService;

    public LoginPresenter(LoginActivity _loginActivity) {
        loginActivity = _loginActivity;
        loginService = new LoginService();
    }

    public void login(final String email, final String password) {
        startLoginProcess();

        UserAuthDTO userAuthDTO = new UserAuthDTO(email, password);

        loginService.login(userAuthDTO, this);
    }

    @Override
    public void startLoginProcess() {
        loginActivity.startLoginProcess();
    }

    @Override
    public void onLoginSuccess() {
        loginActivity.onLoginSuccess();
    }

    @Override
    public void onLoginFailure() {
        loginActivity.onLoginFailure();
    }

}
