package com.info.dao;

import com.info.model.ContactBook;
import org.springframework.stereotype.Repository;

@Repository("contactBookDao")
public class ContactBookDaoImpl extends AbstractDao<Integer, ContactBook> implements ContactBookDao {
   public void save(ContactBook message) {
      this.persist(message);
   }

   public void deleteById(Integer id) {
      try {
         ContactBook message = (ContactBook)this.getByKey(id);
         if (null != message) {
            this.delete(message);
         }
      } catch (Exception var3) {
         ;
      }

   }

   public ContactBook getContactBookById(Integer id) {
      return (ContactBook)this.getByKey(id);
   }
}