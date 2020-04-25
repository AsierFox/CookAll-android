package com.devdream.cookall.context

import android.app.Application
import android.content.Context

class AppContext : Application() {

    init {
        instance = this
    }

    companion object {

        private var instance: AppContext? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        val context: Context = AppContext.applicationContext()
    }

}
