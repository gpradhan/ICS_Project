package com.info.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.context.annotation.Scope;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "CHAT_MESSAGES")

@org.hibernate.annotations.DynamicUpdate
@org.hibernate.annotations.DynamicInsert(false)

@Scope("session")
public class ChatMessage extends SuperEntity<ChatMessage> {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	@SequenceGenerator(name = "ID_SEQUENCE", sequenceName = "CHATMESSAGE_SEQUENCE",allocationSize=1)
	@Column(name = "ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "CHAT_ROOM_ID")
//	@JoinTable(name="CHAT_ROOM_CHAT_MESSAGES", joinColumns=@JoinColumn(name="CHATROOM_ID"), inverseJoinColumns=@JoinColumn(name="CHATROOMMESSAGES_ID"))
	private ChatRoom chatRoom;
	
	@Column(name = "MESSAGE_BODY")
	private String messageBody;
	@Column(name = "TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	
//	@OneToMany(cascade = {CascadeType.PERSIST},
//		      fetch = FetchType.EAGER)
//	private List<ChatRoomAndMessages> chatRommAndMessages = new ArrayList<>();
	
	@Transient
	private List<MultipartFile> file;

	@Transient
	private String userName;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ChatRoom getChatRoom() {
		return this.chatRoom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}

	public String getMessageBody() {
		return this.messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<MultipartFile> getFile() {
		return file;
	}

	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	

//	public List<ChatRoomAndMessages> getChatRommAndMessages() {
//		return chatRommAndMessages;
//	}
//
//	public void setChatRommAndMessages(List<ChatRoomAndMessages> chatRommAndMessages) {
//		this.chatRommAndMessages = chatRommAndMessages;
//	}

	@Override
	public void loadDataFromDB(ChatMessage entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadDataFromUI(ChatMessage entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compare(ChatMessage o1, ChatMessage o2) {
		if((((ChatMessage)o1).getTime()).before(((ChatMessage)o2).getTime()))
			return -1;
		else if((((ChatMessage)o1).getTime()).after(((ChatMessage)o2).getTime()))
			return 1;
		else return 0;
	}

}