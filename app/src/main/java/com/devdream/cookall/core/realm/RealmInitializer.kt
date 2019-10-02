package com.devdream.cookall.core.realm

import com.devdream.cookall.core.context.AppContext
import com.devdream.cookall.core.utils.Constants

import io.realm.Realm
import io.realm.RealmConfiguration

object RealmInitializer {

    fun init() {
        Realm.init(AppContext.context)
        val realmConfiguration = RealmConfiguration.Builder()
                .schemaVersion(Constants.Realm.SCHEMA_VERSION.toLong())
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

}
