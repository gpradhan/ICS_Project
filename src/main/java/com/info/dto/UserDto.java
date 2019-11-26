package com.info.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;

import com.info.model.ContactBook;
import com.info.model.SuperEntity;
import com.info.model.User;

@Scope("session")
public class UserDto extends SuperDto {
	
	private Integer id;
	private Integer employeeId;
	private String name;
	private String userName;
	private String email;
	private String password;
	private String confirmPassword;
	private String mobile;
	private Date loginTime;
	private Date logoutTime;
	private Date dateOfJoining;
	private String key;
	private String userRegistered;
	private String activate;
	private String answer;
	private String hintQuestion = "What is your first pet's name?";
	private String oldPassword;
	private String status;
	
	private Set<ContactBook> contacts = new HashSet<>();

	public String toString() {
		return this.getUserName();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Set<ContactBook> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<ContactBook> contacts) {
		this.contacts = contacts;
	}

	public Date getDateOfJoining() {
		return this.dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getActivate() {
		return this.activate;
	}

	public void setActivate(String activate) {
		this.activate = activate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLogoutTime() {
		return this.logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	public static User setUpdatedFormData(User ui, User db) {
		db.setName(ui.getName());
		db.setEmail(ui.getEmail());
		db.setMobile(ui.getMobile());
		return db;
	}

	public static User setUpdatedFormDataForPassword(User ui, User db) {
		db.setPassword(ui.getPassword());
		return db;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConfirmPassword() {
		return this.confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserRegistered() {
		return this.userRegistered;
	}

	public void setUserRegistered(String userRegistered) {
		this.userRegistered = userRegistered;
	}

	public String getOldPassword() {
		return this.oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getHintQuestion() {
		return hintQuestion;
	}

	public void setHintQuestion(String hintQuestion) {
		this.hintQuestion = hintQuestion;
	}

	public void loadDataFromDB(SuperEntity entity) {

	}

	public void loadDataFromUI(SuperEntity user) {
		User userFromUI = (User) user;
		if (userFromUI.getId() != null)
			this.setId(userFromUI.getId());
		if (userFromUI.getActivate() != null)
			this.setActivate(userFromUI.getActivate());
		if (userFromUI.getAnswer() != null)
			this.setAnswer(userFromUI.getAnswer());
		if (userFromUI.getConfirmPassword() != null)
			this.setConfirmPassword(userFromUI.getConfirmPassword());
		if (userFromUI.getDateOfJoining() != null)
			this.setDateOfJoining(userFromUI.getDateOfJoining());
		if (userFromUI.getEmail() != null)
			this.setEmail(userFromUI.getEmail());
		if (userFromUI.getEmployeeId() != null)
			this.setEmployeeId(userFromUI.getEmployeeId());
		if (userFromUI.getHintQuestion() != null)
			this.setHintQuestion(userFromUI.getHintQuestion());
		if (userFromUI.getKey() != null)
			this.setKey(userFromUI.getKey());
		if (userFromUI.getPassword() != null)
			this.setPassword(userFromUI.getPassword());
		if (userFromUI.getName() != null)
			this.setName(userFromUI.getName());
		if (userFromUI.getUserName() != null)
			this.setUserName(userFromUI.getUserName());
		if (userFromUI.getLoginTime() != null)
			this.setLoginTime(userFromUI.getLoginTime());
		if (userFromUI.getLogoutTime() != null)
			this.setLogoutTime(userFromUI.getLogoutTime());

	}

	@Override
	public SuperDto loadDataFromUI(SuperDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}