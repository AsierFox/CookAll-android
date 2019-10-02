package com.devdream.cookall.core.listeners

import com.devdream.cookall.core.dto.LoginAuthDTO

interface OnLoginFetchedListener {

    fun onLoginSuccess(loginAuthDTO: LoginAuthDTO)
    fun onLoginFailure()

}
