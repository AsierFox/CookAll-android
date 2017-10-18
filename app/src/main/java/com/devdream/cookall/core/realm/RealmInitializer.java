package com.devdream.cookall.core.realm;

import com.devdream.cookall.core.context.AppContext;
import com.devdream.cookall.core.utils.Constants;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmInitializer {

    public static void init() {
        Realm.init(AppContext.context);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(Constants.Realm.SCHEMA_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

}
