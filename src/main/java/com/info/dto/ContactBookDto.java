package com.info.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;

import com.info.model.SuperEntity;

@Scope("session")
public class ContactBookDto extends SuperDto {
	private Integer id;
	private UserDto sourceUser;
	private String name;
	private Integer userId;
	private String email;
	private Date dob;
	private String phone;
	private String city;
	private Integer[] selectedContacts;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public UserDto getSourceUser() {
		return this.sourceUser;
	}

	public void setSourceUser(UserDto sourceUser) {
		this.sourceUser = sourceUser;
	}

	public Integer[] getSelectedContacts() {
		return this.selectedContacts;
	}

	public void setSelectedContacts(Integer[] selectedContacts) {
		this.selectedContacts = selectedContacts;
	}

	@Override
	public void loadDataFromDB(SuperEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SuperDto loadDataFromUI(SuperDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
}