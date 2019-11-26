package com.info.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.context.annotation.Scope;

@Entity
@Table(name = "USERS")
@NamedQueries({ @NamedQuery(name = "User.getMaxUserId", query = "select max(o.id) from User o"),
		@NamedQuery(name = "User.getMaxEmployeeId", query = "select max(o.employeeId) from User o"),
		@NamedQuery(name = "User.findByEmpIdKeyAndUserName", query = "select o from User o where o.employeeId=:employeeId and o.key=:key and o.userName=:userName"),
		@NamedQuery(name = "User.getUserByUserName", query = "select o.id from User o where o.userName=:userName") })
@Scope("session")
public class User extends SuperEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	@SequenceGenerator(name = "ID_SEQUENCE", sequenceName = "USER_SEQUENCE", initialValue=3,allocationSize=1)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;

	@Column(name = "NAME")
	private String name;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "EMAIL")
	private String email;
	
//	@NotEmpty(message="{NotEmpty.employee.password}")
	@Column(name = "PASSWORD")
	private String password;
	
//	@NotEmpty(message="{NotEmpty.employee.confirmPassword}")
	@Column(name = "CONFIRM_PASSWORD")
	private String confirmPassword;
	
	@Column(name = "MOBILE")
	private String mobile;
	@Column(name = "LOGIN_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date loginTime;
	@Column(name = "LOGOUT_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date logoutTime;
	@Column(name = "DATE_OF_JOINING")
	@Temporal(TemporalType.DATE)
	// @DateTimeFormat(pattern="dd-mm-yyyy")
	private Date dateOfJoining;
	@Column(name = "KEY")
	private String key;
	@Column(name = "USER_REGISTERED")
	private String userRegistered;
	@Column(name = "ACTIVATED")
	private String activate;
	
	@Column(name = "ANSWER")
	private String answer;
	
	@Transient
	private String hintQuestion="What is your first pet's name?";
	@Transient
	private String oldPassword;
	@Transient
	private String status;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
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
		this.hintQuestion=hintQuestion;
	}

	public void loadDataFromDB(SuperEntity entity) {
		
		
	}

	public void loadDataFromUI(SuperEntity user) {
		User userFromUI = (User) user;
		if(userFromUI.getId()!=null)
			this.setId(userFromUI.getId());
		if(userFromUI.getActivate()!=null)
			this.setActivate(userFromUI.getActivate());
		if(userFromUI.getAnswer()!=null)
			this.setAnswer(userFromUI.getAnswer());
		if(userFromUI.getConfirmPassword()!=null)
			this.setConfirmPassword(userFromUI.getConfirmPassword());
		if(userFromUI.getDateOfJoining()!=null)
			this.setDateOfJoining(userFromUI.getDateOfJoining());
		if(userFromUI.getEmail()!=null)
			this.setEmail(userFromUI.getEmail());
		if(userFromUI.getEmployeeId()!=null)
			this.setEmployeeId(userFromUI.getEmployeeId());
		if(userFromUI.getHintQuestion()!=null)
			this.setHintQuestion(userFromUI.getHintQuestion());
		if(userFromUI.getKey()!=null)
			this.setKey(userFromUI.getKey());
		if(userFromUI.getPassword()!=null)
			this.setPassword(userFromUI.getPassword());
		if(userFromUI.getName()!=null)
			this.setName(userFromUI.getName());
		if(userFromUI.getUserName()!=null)
			this.setUserName(userFromUI.getUserName());
		if(userFromUI.getLoginTime()!=null)
			this.setLoginTime(userFromUI.getLoginTime());
		if(userFromUI.getLogoutTime()!=null)
			this.setLogoutTime(userFromUI.getLogoutTime());
		
	}

	@Override
	public int compare(SuperEntity o1, SuperEntity o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}