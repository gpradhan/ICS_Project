package com.info.dao;

import org.springframework.stereotype.Repository;

import com.info.model.ChatMessage;

@Repository("chatMessagesDao")
public class ChatMessagesDaoImpl  extends AbstractDao<Integer, ChatMessage> implements ChatMessagesDao{

	public void save(ChatMessage var1) {
		persist(var1);
	}

}
