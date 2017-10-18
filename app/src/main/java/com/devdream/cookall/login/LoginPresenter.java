package com.devdream.cookall.login;

import android.view.View;

import com.devdream.cookall.core.dto.UserAuthDTO;
import com.devdream.cookall.core.exceptions.AuthException;
import com.devdream.cookall.core.services.LoginService;

// TODO Add listeners for login events, refactor
public class LoginPresenter implements LoginListener {

    private LoginActivity loginActivity;
    private LoginService loginService;

    public LoginPresenter(LoginActivity _loginActivity) {
        loginActivity = _loginActivity;
        loginService = new LoginService();
    }

    public void login(final String email, final String password) {
        loginActivity.loadingProgressBar.setVisibility(View.VISIBLE);
        loginActivity.loginButton.setEnabled(false);

        UserAuthDTO userAuthDTO = new UserAuthDTO(email, password);

        try {
            loginService.login(userAuthDTO);

            loginActivity.navigateHome();
        }
        catch (AuthException e) {
            loginActivity.showLoginError();
        }
        finally {
            loginActivity.loadingProgressBar.setVisibility(View.GONE);
            loginActivity.loginButton.setEnabled(true);
        }
    }

}
