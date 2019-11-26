package com.info.dao;

import java.util.List;

import com.info.model.ChatRoom;

public interface ChatRoomDao {
   String FIND_ID_BY_ROOM_AND_KEY = "Message.findByRoomAndKey";

   public ChatRoom findById(int id);
   
   void save(ChatRoom var1);

   void deleteById(Integer var1);

   ChatRoom getChatRoomById(Integer var1);

   List<ChatRoom> getListByQuery(String var1, Object... var2);

   ChatRoom getSingleResultByQuery(String var1, Object... var2);

}