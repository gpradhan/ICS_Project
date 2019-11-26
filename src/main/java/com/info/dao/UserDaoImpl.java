package com.info.dao;

import com.info.model.ContactBook;
import com.info.model.User;
import javax.persistence.NoResultException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
	@Autowired
	private ContactBookDaoImpl contactBookDao;

	public User findById(int id) {
		return (User) this.getByKey(id);
	}

	public User findByUserAndPassword(User user) {
		Query query = this.getSession().createQuery("from User u where u.userName=?0 and u.password=?1");
		query.setParameter(0, user.getUserName());
		query.setParameter(1, user.getPassword());

		try {
			return (User) query.getSingleResult();
		} catch (Exception var4) {
			return null;
		}
	}
	
	public User findByEmpIdKeyAndUserName(Integer employeeId,String key,String userName) {
		try {
			return (User) this.getSession().getNamedQuery("User.findByEmpIdKeyAndUserName").setInteger("employeeId", employeeId).setString("key", key).setString("userName", userName)
					.getSingleResult();
		} catch (NoResultException var4) {
			return null;
		}
	}

	public void save(User myUser) {
		this.persist(myUser);
	}

	public User updateUser(User myUser) {
		return this.merge(myUser);
	}

	public Integer getMaxId() {
		return (Integer) this.getSession().getNamedQuery("User.getMaxEmployeeId").getSingleResult();
	}

	public Integer getByUserName(String userName) {
		Integer id = null;

		try {
			id = (Integer) this.getSession().getNamedQuery("User.getUserByUserName").setString("userName", userName)
					.getSingleResult();
		} catch (NoResultException var4) {
			return null;
		}

		return id;
	}

	public void deleteContacts(User myUser, Integer[] selectedContacts) {
		User userFromDB = (User) this.getByKey(myUser.getId());
		Query query = this.getSession().getNamedQuery("ContactBook.getContactById");
		Integer[] var5 = selectedContacts;

		for (int var7 = 0; var7 < selectedContacts.length; ++var7) {
			Integer contactId = var5[var7];
			ContactBook contactBook = (ContactBook) query.setInteger("id", contactId).getSingleResult();
			userFromDB.getContacts().remove(contactBook);
			this.contactBookDao.delete(contactBook);
		}

	}
}