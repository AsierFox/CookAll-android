package com.devdream.cookall.core.dto

import com.stfalcon.chatkit.commons.models.IMessage
import com.stfalcon.chatkit.commons.models.IUser

import java.util.Date

class ChatMessageDTO : IMessage {

    var id: String? = null
    var text: String? = null
    var user: IUser? = null
    var createdAt: Date? = null

    override fun getId(): String? {
        return id
    }

    override fun getText(): String? {
        return text
    }

    override fun getUser(): IUser? {
        return user
    }

    override fun getCreatedAt(): Date? {
        return createdAt
    }

}
