package com.devdream.cookall.core.dto

import com.stfalcon.chatkit.commons.models.IUser

class ChatUserDTO : IUser {

    var id: String? = null
    var name: String? = null
    var avatar: String? = null

    override fun getId(): String? {
        return id
    }

    override fun getName(): String? {
        return name
    }

    override fun getAvatar(): String? {
        return avatar
    }

}
