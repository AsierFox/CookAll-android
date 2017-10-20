package com.devdream.cookall.core.listeners;

import com.devdream.cookall.core.dto.LoginAuthDTO;

public interface OnLoginFetchedListener {

    void onLoginSuccess(final LoginAuthDTO loginAuthDTO);
    void onLoginFailure();

}
