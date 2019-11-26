package com.info.dto;

import org.springframework.context.annotation.Scope;

import com.info.model.SuperEntity;

@Scope("session")
public class ChatMessageDto extends SuperDto{
   private Integer id;
   private ChatRoomDto chatRoomDto;
   private String messageBody;
   private String userName;

   public Integer getId() {
      return this.id;
   }

   public void setId(Integer id) {
      this.id = id;
   }


   public ChatRoomDto getChatRoomDto() {
	return chatRoomDto;
}

public void setChatRoomDto(ChatRoomDto chatRoomDto) {
	this.chatRoomDto = chatRoomDto;
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