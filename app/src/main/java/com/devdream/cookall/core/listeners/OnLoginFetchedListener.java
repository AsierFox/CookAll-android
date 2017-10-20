package com.devdream.cookall.login;

import com.devdream.cookall.core.dto.LoginAuthDTO;

public interface OnLoginFinishedListener {

    void onLoginSuccess(final LoginAuthDTO loginAuthDTO);
    void onLoginFailure();

}
