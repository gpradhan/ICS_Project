package com.info.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.context.annotation.Scope;

import com.info.model.SuperEntity;

@Scope("session")
public class ChatRoomDto extends SuperDto {
	private Integer id;
	private String roomName;
	private String key;
	private UserDto owner;
	private String userName;
	private List<ChatMessageDto> chatRoomMessages = new ArrayList<>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public UserDto getOwner() {
		return owner;
	}

	public void setOwner(UserDto owner) {
		this.owner = owner;
	}

	public List<ChatMessageDto> getChatRoomMessages() {
		return chatRoomMessages;
	}

	public void setChatRoomMessages(List<ChatMessageDto> chatRoomMessages) {
		this.chatRoomMessages = chatRoomMessages;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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