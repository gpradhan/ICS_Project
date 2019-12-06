package com.info.service;

import com.info.dao.ContactBookDaoImpl;
import com.info.dao.UserDaoImpl;
import com.info.model.ContactBook;
import com.info.model.User;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDaoImpl userDao;
	@Autowired
	private ContactBookDaoImpl contactBookDao;

	@Transactional(readOnly = true)
	public User findByUserAndPassword(User user) {
		return userDao.findByUserAndPassword(user);
	}

	@Transactional(readOnly = true)
	public List<User> userList() {
		return userDao.getListByQuery("from User u", (Object[]) null);
	}

	@Transactional(readOnly = true)
	public User findById(Integer id) {
		return userDao.findById(id);
	}

	@Transactional(readOnly = false)
	public User update(User myUser) {
		User user = this.findById(myUser.getId());
		User.setUpdatedFormData(myUser, user);
		return (User) userDao.update(user);
	}

	@Transactional(readOnly = false)
	public User updateUser(User myUser) {
		return userDao.updateUser(myUser);
	}

	@Transactional(readOnly = false)
	public User updatePassword(User myUser) {
		User user = null;
		Integer id = null;

		try {
			if (myUser.getId() == null) {
				id = userDao.getByUserName(myUser.getUserName());
				user = this.findById(id);
			} else {
				user = this.findById(myUser.getId());
			}

			User.setUpdatedFormDataForPassword(myUser, user);
			return (User) userDao.update(user);
		} catch (Exception var5) {
			return null;
		}
	}
	
	@Transactional(readOnly = false)
	public User resetPassword(User myUser) {
		Object[] param= new Object[3];
		param[0]=myUser.getUserName();
		param[1]=myUser.getOldPassword();
		param[2]=myUser.getAnswer();
		try {
			User user = userDao.getSingleResultByQuery("from User u where u.userName=?0 and u.password=?1 and u.answer=?2", param);
			User.setUpdatedFormDataForPassword(myUser, user);
			return (User) userDao.update(user);
		} catch (Exception var5) {
			return null;
		}
	}

	@Transactional(readOnly = false)
	public void delete(Integer id) {
		userDao.deleteById(id);
	}

	@Transactional(readOnly = false)
	public void addContact(User myUser, ContactBook contactBook) {
		User userFromDB = this.findById(myUser.getId());
		contactBook.setSourceUser(userFromDB);
		userFromDB.getContacts().add(contactBook);
	}

	@Transactional(readOnly = false)
	public void save(User myUser) {
		userDao.save(myUser);
	}

	@Transactional(readOnly = true)
	public Integer getMaxId() {
		return userDao.getMaxId();
	}

	@Transactional(readOnly = true)
	public Integer getIdByUserName(String userName) {
		return userDao.getByUserName(userName);
	}

	@Transactional(readOnly = false)
	public void activateUser(Integer id) {
		User user = userDao.findById(id);
		user.setActivate("y");
	}

	@Transactional(readOnly = false)
	public void banUser(Integer id) {
		User user = userDao.findById(id);
		user.setActivate("n");
	}

	@Transactional(readOnly = false)
	public void deleteContacts(User myUser, Integer[] selectedContacts) {
		userDao.deleteContacts(myUser, selectedContacts);
	}

	@Transactional(readOnly = false)
	public void logout(Integer id) {
		User user1 = userDao.findById(id);
		user1.setLogoutTime(new Date());
	}

	@Transactional(readOnly = false)
	public void login(Integer id) {
		User user1 = userDao.findById(id);
		user1.setLoginTime(new Date());
		user1.setLogoutTime((Date) null);
	}

	@Transactional(readOnly = true)
	public User findByEmpIdKeyAndUserName(Integer employeeId, String key, String userName) {
		return userDao.findByEmpIdKeyAndUserName(employeeId,key,userName);
	}

}