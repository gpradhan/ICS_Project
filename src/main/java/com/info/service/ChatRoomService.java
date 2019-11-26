package com.info.service;

import com.info.model.ChatMessage;
import com.info.model.ChatRoom;
import java.util.List;

public interface ChatRoomService {
   void addChatRoom(ChatRoom var1);

   List<ChatRoom> getListByQuery(String var1, Object... var2);

   ChatRoom findByRoomAndKey(ChatRoom var1);

   void saveChatRoomMessage(ChatRoom var1, ChatMessage var2);
}
    