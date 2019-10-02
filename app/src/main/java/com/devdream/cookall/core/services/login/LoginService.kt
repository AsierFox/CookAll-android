package com.devdream.cookall.core.services.login

import com.devdream.cookall.core.dto.UserAuthDTO
import com.devdream.cookall.core.listeners.OnLoginFetchedListener

interface LoginService {

    fun login(userDTO: UserAuthDTO, onLoginFinishedListener: OnLoginFetchedListener)

}
