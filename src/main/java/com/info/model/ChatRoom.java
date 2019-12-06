package com.info.model;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

@Entity
@Table(
   name = "CHAT_ROOM"
)
@NamedQueries({@NamedQuery(
   name = "Message.findByRoomAndKey",
   query = "select o from ChatRoom o where o.roomName=:roomName and o.key=:key "
)})
@Scope("session")
public class ChatRoom  extends SuperEntity<ChatRoom>{
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ID_SEQUENCE")
   @SequenceGenerator(name="ID_SEQUENCE",sequenceName="CHATROOM_SEQUENCE",allocationSize=1)
   @Column(
      name = "ID"
   )
   private Integer id;
   @Column(
      name = "ROOM_NAME"
   )
   private String roomName;
   @Column(
      name = "KEY"
   )
   private String key;
   @ManyToOne
   @JoinColumn(
      name = "USER_ID"
   )
   private User owner;
   @Transient
   private String userName;
   
	@OneToMany(
      cascade = {CascadeType.ALL},
      fetch = FetchType.EAGER
   )
//   private Set<ChatMessage> chatRoomMessages = new TreeSet<>((o1, o2) -> (int)(o1.getTime().getTime()- o2.getTime().getTime()));
	private Set<ChatMessage> chatRoomMessages = new TreeSet<>();
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

   public User getOwner() {
      return this.owner;
   }

   public void setOwner(User owner) {
      this.owner = owner;
   }

   public Set<ChatMessage> getChatRoomMessages() {
//	   Collections.sort(this.chatRoomMessages);
     return this.chatRoomMessages;
   }

   public void setChatRoomMessages(Set<ChatMessage> chatRoomMessages) {
      this.chatRoomMessages = chatRoomMessages;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

@Override
public void loadDataFromDB(ChatRoom entity) {
	// TODO Auto-generated method stub
	
}

@Override
public void loadDataFromUI(ChatRoom entity) {
	// TODO Auto-generated method stub
	
}

@Override
public int compare(ChatRoom o1, ChatRoom o2) {
//	if((((ChatMessage)o1).getTime()).before(((ChatMessage)o2).getTime()))
//		return -1;
//	else if((((ChatMessage)o1).getTime()).before(((ChatMessage)o2).getTime()))
//		return 1;
//	else 
		return 0;
}
}