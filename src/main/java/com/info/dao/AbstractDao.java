package com.info.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.info.model.User;

public abstract class AbstractDao<PK extends Serializable, T> {
   private final Class<T> persistentClass = (Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
   @Autowired
   private SessionFactory sessionFactory;

   protected Session getSession() {
      return this.sessionFactory.getCurrentSession();
   }

   public T getByKey(PK key) {
      return this.getSession().get(this.persistentClass, key);
   }

   public void persist(T entity) {
      this.getSession().persist(entity);
   }

   public void delete(T entity) {
      this.getSession().delete(entity);
   }

   public void deleteById(PK id) {
      T entity = this.getByKey(id);
      if (entity != null) {
         this.getSession().delete(entity);
      }

   }

   protected Criteria createEntityCriteria() {
      return this.getSession().createCriteria(this.persistentClass);
   }

   public T update(T entity) {
      this.getSession().saveOrUpdate(entity);
      return entity;
   }

   public T merge(T entity) {
      try {
    	 this.getSession().get(this.persistentClass,((User)entity).getId());
		return (T) this.getSession().merge(entity);
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
   }

   public List<T> getListByQuery(String hql, Object... params) {
      try {
         TypedQuery<T> query = this.getSession().createQuery(hql);
         if (params != null) {
            for(int i = 0; i < params.length; ++i) {
               query.setParameter(i, params[i]);
            }
         }

         return query.getResultList();
      } catch (NoResultException var5) {
         return null;
      }
   }

   public T getSingleResultByQuery(String hql, Object... params) {

         TypedQuery<T> query = this.getSession().createQuery(hql);
         if (params != null) {
            for(int i = 0; i < params.length; ++i) {
               query.setParameter(i, params[i]);
            }
         }

         return query.getSingleResult();
      
   }
}