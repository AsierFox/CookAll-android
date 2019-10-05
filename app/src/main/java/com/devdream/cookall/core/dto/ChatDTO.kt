package com.devdream.cookall.core.dto

import java.util.*

class ChatDTO {

    var id: String? = null
    var photo: String? = null
    var name: String? = null
    var users: List<ChatUserDTO>
    // ChatMessageDTO implements IMessage
    var lastMessage : ChatMessageDTO? = null
    var unreadMessagesCount: Int = 0

    init {
        users = ArrayList()
    }

}
