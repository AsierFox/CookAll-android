package com.devdream.cookall.core.dto

import com.stfalcon.chatkit.commons.models.IDialog
import com.stfalcon.chatkit.commons.models.IMessage
import com.stfalcon.chatkit.commons.models.IUser

import java.util.ArrayList

class ChatDTO : IDialog<*> {

    var id: String? = null
    var photo: String? = null
    var name: String? = null
    var users: List<ChatUserDTO>
    // ChatMessageDTO implements IMessage
    var lastMessage: IMessage
    var unreadMessagesCount: Int = 0

    init {
        users = ArrayList()
    }

    override fun getId(): String? {
        return id
    }

    override fun getDialogPhoto(): String? {
        return photo
    }

    override fun getDialogName(): String? {
        return name
    }

    override fun getUsers(): List<IUser> {
        return users
    }

    override fun getLastMessage(): IMessage {
        return lastMessage
    }

    override fun setLastMessage(message: IMessage) {
        lastMessage = message
    }

    override fun getUnreadCount(): Int {
        return unreadMessagesCount
    }

}
