package com.devdream.cookall.core.realm.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserRealm : RealmObject() {

    @PrimaryKey
    var id: Int = 0
    var name: String? = null
    var surnames: String? = null
    var avatar: String? = null
    var gender: String? = null

}
