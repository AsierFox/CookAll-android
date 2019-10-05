package com.devdream.cookall.login

import com.devdream.cookall.core.dto.LoginAuthDTO
import com.devdream.cookall.core.dto.UserAuthDTO
import com.devdream.cookall.core.exceptions.NoNetworkAccessException
import com.devdream.cookall.core.interactors.LoginInteractor
import com.devdream.cookall.core.listeners.OnLoginFetchedListener

class LoginPresenter(private val loginListener: LoginListener) : LoginListener, OnLoginFetchedListener {

    private val loginInterator: LoginInteractor = LoginInteractor()

    fun login(email: String, password: String) {
        startLoginProcess()

        val userAuthDTO = UserAuthDTO()

        try {
            loginInterator.login(userAuthDTO, this)
        } catch (e: NoNetworkAccessException) {
            noNetworkAccessError()
        }

    }

    override fun startLoginProcess() {
        loginListener.startLoginProcess()
    }

    override fun successLoginProcess() {
        loginListener.successLoginProcess()
    }

    override fun errorLoginProcess() {
        loginListener.errorLoginProcess()
    }

    override fun onLoginSuccess(loginAuthDTO: LoginAuthDTO) {
        successLoginProcess()
    }

    override fun onLoginFailure() {
        errorLoginProcess()
    }

    override fun noNetworkAccessError() {
        loginListener.noNetworkAccessError()
    }

}
