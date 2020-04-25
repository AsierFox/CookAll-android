package com.devdream.cookall.modules.auth

import android.view.View

interface AuthContract {

    interface LoginView {
        fun loginOnClick(view: View)
    }

}