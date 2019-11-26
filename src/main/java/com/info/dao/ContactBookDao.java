package com.info.dao;

import com.info.model.ContactBook;
import java.util.List;

public interface ContactBookDao {
   void save(ContactBook var1);

   void deleteById(Integer var1);

   ContactBook getContactBookById(Integer var1);

   List<ContactBook> getListByQuery(String var1, Object... var2);

   ContactBook getSingleResultByQuery(String var1, Object... var2);
}