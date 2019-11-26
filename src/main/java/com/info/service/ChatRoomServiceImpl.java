package com.info.service;

import com.info.dao.ChatMessagesDaoImpl;
import com.info.dao.ChatRoomDaoImpl;
import com.info.model.ChatMessage;
import com.info.model.ChatRoom;
import com.info.model.User;

import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {
	
   @Autowired
   private ChatRoomDaoImpl dao;
   
   @Autowired
	private ChatMessagesDaoImpl chatMessagesDao;

   @Transactional(
      readOnly = false
   )
   public void addChatRoom(ChatRoom chatRoom) {
      this.dao.save(chatRoom);
   }

   @Transactional(
      readOnly = true
   )
   public List<ChatRoom> getListByQuery(String query, Object... params) {
      return this.dao.getListByQuery(query, params);
   }

   @Transactional(
      readOnly = true
   )
   public ChatRoom findByRoomAndKey(ChatRoom chatRoom) {
      return this.dao.findByRoomAndKey(chatRoom);
   }

   @Transactional(
      readOnly = false
   )
   public void saveChatRoomMessage(ChatRoom chatRoom, ChatMessage chatMessage) {
//      this.dao.saveChatRoomMessage(chatRoom, chatMessage);
	 ChatRoom roomFromDB = findById(chatRoom.getId());
	 chatMessage.setChatRoom(roomFromDB);
     roomFromDB.getChatRoomMessages().add(chatMessage);
   }
   
   @Transactional(readOnly = true)
	public ChatRoom findById(Integer id) {
		return dao.findById(id);
	}
}