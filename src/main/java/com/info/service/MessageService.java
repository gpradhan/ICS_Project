package com.info.service;

import com.info.model.Message;
import java.util.List;

public interface MessageService {
   void addMessage(Message var1);

   List<Message> getListByQuery(String var1, Object... var2);

   Message findById(Integer var1);

   void delete(Integer var1);
}