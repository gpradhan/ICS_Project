package com.info.dao;

import com.info.model.Message;
import java.util.List;

public interface MessageDao {
   void save(Message var1);

   void deleteById(Integer var1);

   Message getMessageById(Integer var1);

   List<Message> getListByQuery(String var1, Object... var2);

   Message getSingleResultByQuery(String var1, Object... var2);
}
    