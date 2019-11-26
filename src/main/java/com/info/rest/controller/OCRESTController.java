package com.info.rest.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.info.service.ChatRoomService;
import com.info.service.MessageService;
import com.info.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping({ "/" })
@SessionAttributes({ "user", "chatRoomSessionObj" })
@Scope("session")
public class OCRESTController {

	Logger logger = LoggerFactory.getLogger(OCRESTController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private ChatRoomService chatRoomService;

	@GetMapping({ "/indexRest" })
	@ApiOperation(value = "Get homepage name ", response = String.class, tags = "indexRest1")
	public String indexRest(Locale locale, Model model) {
		return "index";
	}

	
}