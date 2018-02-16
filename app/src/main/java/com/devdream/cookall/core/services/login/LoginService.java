package com.devdream.cookall.core.services.login;

import com.devdream.cookall.core.dto.UserAuthDTO;
import com.devdream.cookall.core.listeners.OnLoginFetchedListener;

public interface LoginService {

    void login(UserAuthDTO userDTO, final OnLoginFetchedListener onLoginFinishedListener);

}
