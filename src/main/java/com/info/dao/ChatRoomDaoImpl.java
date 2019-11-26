package com.info.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.info.model.ChatMessage;
import com.info.model.ChatRoom;
import com.info.model.User;

@Repository("chatRoomDao")
public class ChatRoomDaoImpl extends AbstractDao<Integer, ChatRoom> implements ChatRoomDao {
	
	public ChatRoom findById(int id) {
		return (ChatRoom) this.getByKey(id);
	}
	
   public void save(ChatRoom chatRoom) {
      this.persist(chatRoom);
   }

   public void deleteById(Integer id) {
      try {
         ChatRoom chatRoom = (ChatRoom)this.getByKey(id);
         if (null != chatRoom) {
            this.delete(chatRoom);
         }
      } catch (Exception var3) {
         ;
      }

   }

   public ChatRoom getChatRoomById(Integer id) {
      return (ChatRoom)this.getByKey(id);
   }

   public ChatRoom findByRoomAndKey(ChatRoom chatRoom) {
      Query query = this.getSession().getNamedQuery("Message.findByRoomAndKey");
      query.setString("roomName", chatRoom.getRoomName());
      query.setString("key", chatRoom.getKey());

      try {
         ChatRoom room = (ChatRoom)query.getSingleResult();
         return room;
      } catch (Exception var4) {
         return null;
      }
   }

}
    