package com.devdream.cookall.core.repositories;

import com.devdream.cookall.core.dto.UserAuthDTO;
import com.devdream.cookall.core.exceptions.NoNetworkAccessException;
import com.devdream.cookall.login.OnLoginFinishedListener;

public interface LoginRepository {

    void login(UserAuthDTO userDTO, final OnLoginFinishedListener onLoginFinishedListener) throws NoNetworkAccessException;

}
