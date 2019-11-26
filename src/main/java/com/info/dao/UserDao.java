package com.info.dao;

import com.info.model.User;
import java.util.List;

public interface UserDao {
   String GET_MAX_ID = "User.getMaxUserId";
   String GET_USER_BY_USER_NAME = "User.getUserByUserName";
   String GET_CONTACT_BY_ID = "ContactBook.getContactById";

   User findById(int var1);

   User findByUserAndPassword(User var1);
   
   User findByEmpIdKeyAndUserName(Integer employeeId,String key,String userName);

   void save(User var1);
   
   public User updateUser(User myUser);

   List<User> getListByQuery(String var1, Object... var2);

   User getSingleResultByQuery(String var1, Object... var2);

   Integer getMaxId();

   Integer getByUserName(String var1);

   void deleteContacts(User var1, Integer[] var2);
}