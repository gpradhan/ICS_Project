package com.info.dto;

import java.util.Date;

import org.springframework.context.annotation.Scope;

import com.info.model.SuperEntity;

@Scope("session")
public class MessageDto extends SuperDto {
	private Integer id;
	private Integer fromUser;
	private Integer toUser;
	private Date time;
	private String subject;
	private String messageBody;
	private String fromUserName;
	private String toUserName;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFromUser() {
		return this.fromUser;
	}

	public void setFromUser(Integer fromUser) {
		this.fromUser = fromUser;
	}

	public Integer getToUser() {
		return this.toUser;
	}

	public void setToUser(Integer toUser) {
		this.toUser = toUser;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessageBody() {
		return this.messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getFromUserName() {
		return this.fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getToUserName() {
		return this.toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
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