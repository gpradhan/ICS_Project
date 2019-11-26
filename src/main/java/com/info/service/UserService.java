package com.info.service;

import com.info.model.ContactBook;
import com.info.model.User;
import java.util.List;

import javax.persistence.NoResultException;

public interface UserService {
   User findByUserAndPassword(User var1);

   void save(User var1);

   List<User> userList();

   User findById(Integer var1);

   User update(User var1);
   
   public User updateUser(User user);
   
   public User findByEmpIdKeyAndUserName(Integer employeeId, String key, String userName);

   void delete(Integer var1);

   void addContact(User var1, ContactBook var2);

   Integer getMaxId();

   Integer getIdByUserName(String var1);

   void activateUser(Integer var1);

   void banUser(Integer var1);

   void deleteContacts(User var1, Integer[] var2);

   void logout(Integer var1);

   void login(Integer var1);

   User updatePassword(User var1);
}
    