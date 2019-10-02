package com.devdream.cookall.login

import com.devdream.cookall.core.listeners.NetworkListener

internal interface LoginListener : NetworkListener {

    fun startLoginProcess()
    fun successLoginProcess()
    fun errorLoginProcess()

}
