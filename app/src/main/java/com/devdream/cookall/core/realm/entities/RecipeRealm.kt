package com.devdream.cookall.core.realm.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RecipeRealm : RealmObject {

    @PrimaryKey
    var id: String? = null
    var title: String? = null
    var description: String? = null

    constructor() {}

    constructor(_id: String?, _title: String, _description: String) {
        id = _id
        title = _title
        description = _description
    }

}
