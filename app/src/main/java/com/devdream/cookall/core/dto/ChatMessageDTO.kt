package com.devdream.cookall.core.dto

import java.util.Date

class ChatMessageDTO {

    var id: String? = null
    var text: String = ""
    var user: ChatUserDTO? = null
    var createdAt: Date? = null

}
