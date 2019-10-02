package com.devdream.cookall.core.utils

object Constants {

    val APP_NAME = "CookAll"

    interface API {
        companion object {
            val BASE_URL = "http://cookall.devdream.eu"
        }
    }

    interface Realm {
        companion object {
            val SCHEMA_VERSION = 1
        }
    }

}
