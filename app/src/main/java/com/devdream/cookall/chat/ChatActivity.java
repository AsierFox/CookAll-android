package com.devdream.cookall.chat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.devdream.cookall.R;
import com.devdream.cookall.core.context.AppContext;
import com.devdream.cookall.core.dto.ChatDTO;
import com.devdream.cookall.core.dto.ChatMessageDTO;
import com.devdream.cookall.core.dto.ChatUserDTO;
import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.dialogs.DialogsList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatActivity extends AppCompatActivity
        implements DialogsListAdapter.OnDialogClickListener<ChatDTO>,
        DialogsListAdapter.OnDialogLongClickListener<ChatDTO> {

    private DialogsListAdapter dialogsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DialogsList dialogsList = (DialogsList) findViewById(R.id.dialogs_list);

        ImageLoader imageLoader = new ImageLoader() {
            @Override
            public void loadImage(ImageView imageView, String url) {
                Picasso.with(AppContext.context).load(url).into(imageView);
            }
        };

        dialogsAdapter = new DialogsListAdapter(imageLoader);

        List<ChatDTO> chats = new ArrayList<>();

        ChatDTO chat1 = new ChatDTO();
        chat1.id = "1";
        chat1.photo = "https://www.burgesshillphysio.co.uk/wp-content/uploads/2016/09/" +
                "Simple-avatar-200x200.png";
        chat1.name = "Test chat";

        ChatUserDTO user1 = new ChatUserDTO();
        user1.id = "2";
        user1.name = "Asier";
        user1.avatar = "https://www.burgesshillphysio.co.uk/wp-content/uploads/2016/09/" +
                "Simple-avatar-200x200.png";

        chat1.users.add(user1);

        ChatMessageDTO chatMessage1 = new ChatMessageDTO();
        chatMessage1.id = "3";
        chatMessage1.text = "This is the last message ^.^";
        chatMessage1.user = user1;
        chatMessage1.createdAt = new Date();

        chat1.lastMessage = chatMessage1;
        chat1.unreadMessagesCount = 1;

        dialogsList.setAdapter(dialogsAdapter);

        dialogsAdapter.setItems(chats);
    }

    @Override
    public void onDialogClick(ChatDTO dialog) {

    }

    @Override
    public void onDialogLongClick(ChatDTO dialog) {

    }
}
