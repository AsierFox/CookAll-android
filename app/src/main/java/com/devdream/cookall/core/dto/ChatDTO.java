package com.devdream.cookall.core.dto;

import com.stfalcon.chatkit.commons.models.IDialog;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.IUser;

import java.util.ArrayList;
import java.util.List;

public class ChatDTO implements IDialog {

    public String id;
    public String photo;
    public String name;
    public List<ChatUserDTO> users;
    // ChatMessageDTO implements IMessage
    public IMessage lastMessage;
    public int unreadMessagesCount;

    public ChatDTO() {
        users = new ArrayList<>();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDialogPhoto() {
        return photo;
    }

    @Override
    public String getDialogName() {
        return name;
    }

    @Override
    public List<? extends IUser> getUsers() {
        return users;
    }

    @Override
    public IMessage getLastMessage() {
        return lastMessage;
    }

    @Override
    public void setLastMessage(IMessage message) {
        lastMessage = message;
    }

    @Override
    public int getUnreadCount() {
        return unreadMessagesCount;
    }

}
