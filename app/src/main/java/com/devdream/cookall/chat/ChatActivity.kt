package com.devdream.cookall.chat

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.devdream.cookall.R
import com.devdream.cookall.core.dto.ChatDTO
import com.devdream.cookall.core.dto.ChatMessageDTO
import com.devdream.cookall.core.dto.ChatUserDTO
import java.util.*

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val chats = ArrayList<ChatDTO>()

        val chat1 = ChatDTO()
        chat1.id = "1"
        chat1.photo = "https://www.burgesshillphysio.co.uk/wp-content/uploads/2016/09/" + "Simple-avatar-200x200.png"
        chat1.name = "Test chat"

        val user1 = ChatUserDTO()
        user1.id = "2"
        user1.name = "Asier"
        user1.avatar = "https://www.burgesshillphysio.co.uk/wp-content/uploads/2016/09/" + "Simple-avatar-200x200.png"

        //chat1.users.add(user1)

        val chatMessage1 = ChatMessageDTO()
        chatMessage1.id = "3"
        chatMessage1.text = "This is the last message ^.^"
        chatMessage1.user = user1
        chatMessage1.createdAt = Date()

        chat1.lastMessage = chatMessage1
        chat1.unreadMessagesCount = 1

    }

}
