package com.info.dao;

import com.info.model.Message;
import org.springframework.stereotype.Repository;

@Repository("messageDao")
public class MessageDaoImpl extends AbstractDao<Integer, Message> implements MessageDao {
   public void save(Message message) {
      this.persist(message);
   }

   public void deleteById(Integer id) {
      try {
         Message message = (Message)this.getByKey(id);
         if (null != message) {
            this.delete(message);
         }
      } catch (Exception var3) {
         ;
      }

   }

   public Message getMessageById(Integer id) {
      return (Message)this.getByKey(id);
   }
}