package com.devdream.cookall.core.interactors

import com.devdream.cookall.core.context.AppContext
import com.devdream.cookall.core.dto.UserAuthDTO
import com.devdream.cookall.core.exceptions.NoNetworkAccessException
import com.devdream.cookall.core.listeners.OnLoginFetchedListener
import com.devdream.cookall.core.services.login.LoginAPIService
import com.devdream.cookall.core.services.login.LoginService
import com.devdream.cookall.core.utils.ConnectivityUtil

class LoginInteractor {

    private val loginService: LoginService

    init {
        loginService = LoginAPIService()
    }

    @Throws(NoNetworkAccessException::class)
    fun login(userDTO: UserAuthDTO, onLoginFinishedListener: OnLoginFetchedListener) {

        if (ConnectivityUtil.isConnected(AppContext.context)) {
            loginService.login(userDTO, onLoginFinishedListener)
        } else {
            throw NoNetworkAccessException()
        }
    }

}
