package com.info.service;

import com.info.dao.MessageDaoImpl;
import com.info.model.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl implements MessageService {
   @Autowired
   private MessageDaoImpl dao;

   @Transactional(
      readOnly = false
   )
   public void addMessage(Message message) {
      this.dao.save(message);
   }

   @Transactional(
      readOnly = true
   )
   public Message findById(Integer id) {
      return (Message)this.dao.getByKey(id);
   }

   @Transactional(
      readOnly = true
   )
   public List<Message> getListByQuery(String query, Object... params) {
      return this.dao.getListByQuery(query, params);
   }

   @Transactional(
      readOnly = false
   )
   public void delete(Integer id) {
      this.dao.deleteById(id);
   }
}