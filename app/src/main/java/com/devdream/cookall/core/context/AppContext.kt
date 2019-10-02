package com.devdream.cookall.core.context

import android.app.Application
import android.content.Context

class AppContext : Application() {

    override fun onCreate() {
        super.onCreate()
        AppContext.context = applicationContext
    }

    companion object {

        var context: Context
    }

}
