package com.info.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.info.model.ChatMessage;
import com.info.model.ChatRoom;
import com.info.model.ContactBook;
import com.info.model.Message;
import com.info.model.User;
import com.info.service.ChatRoomService;
import com.info.service.MessageService;
import com.info.service.UserService;

@Controller
@RequestMapping({ "/" })
@SessionAttributes({ "user", "chatRoomSessionObj" })
@Scope("session")
public class OCController {

	Logger logger = LoggerFactory.getLogger(OCController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private ChatRoomService chatRoomService;

	@GetMapping({ "/" })
	public String index(Locale locale, Model model) {
		return "index";
	}

	private User setSessionUserToModel(HttpSession session, Model model) {
		User myUser = (User) session.getAttribute("user");
		model.addAttribute("myUser", myUser);
		return myUser;
	}

	@GetMapping({ "/index" })
	public String index1(Locale locale, Model model) {
		return "index";
	}

	@GetMapping({ "/adminloginform" })
	public String adminloginform(Locale locale, Model model) {
		model.addAttribute("myUser", new User());
		return "adminloginform";
	}

	@GetMapping({ "/userloginform" })
	public String userloginform(Locale locale, Model model) {
		model.addAttribute("myUser", new User());
		return "userloginform";
	}

	@GetMapping({ "/forgotPassword" })
	public String forgotPassword(Locale locale, Model model) {
		model.addAttribute("myUser", new User());
		return "resetPasswordForm";
	}

	@GetMapping({ "/signupForm" })
	public String signupform(Locale locale, Model model) {
		model.addAttribute("employee", new User());
		return "signupForm";
	}

	@PostMapping({ "/signupEmployee" })
	public String signupEmployee(Locale locale, Model model, @ModelAttribute("employee") User user) {
		User userFromDB = userService.findByEmpIdKeyAndUserName(user.getEmployeeId(), user.getKey(),
				user.getUserName());
		if (userFromDB != null) {
			if (userFromDB.getUserRegistered().equals("y")) {
				model.addAttribute("resultMessage", "Employee already registered");
				return "signupForm";
			}
			model.addAttribute("employee", userFromDB);
			return "signupDetailsForm";
		} else {
			model.addAttribute("resultMessage", "Please enter valid data !!");
			return "signupForm";
		}
	}

	@PostMapping({ "/registerEmployee" })
	public String signupDetailsform(Locale locale, Model model, @ModelAttribute("employee") @Valid User user,
			BindingResult result) {
		if (result.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for (ObjectError error : result.getAllErrors()) {
				sb.append(error.getDefaultMessage() + " ");
			}
			model.addAttribute("resultMessage", sb.toString());
		} else {
			// userFromDB will never be null
			User userFromDB = userService.findById(user.getId());
			// update data from UI
			userFromDB.loadDataFromUI(user);
			userFromDB.setUserRegistered("y");
			userFromDB = userService.updateUser(userFromDB);
			if (userFromDB != null) {
				model.addAttribute("resultMessage", "Employee registered successfully");
			} else {
				model.addAttribute("resultMessage", "Employee registration failed");
			}
		}
		return "signupForm";
	}

	@GetMapping({ "/address" })
	public String address(Locale locale, Model model, HttpSession session) {
		User myUser = setSessionUserToModel(session, model);
		if (myUser == null) {
			return "index";
		} else {
			User userFromDB = userService.findById(myUser.getId());
			this.setSessionUserToModel(session, model);
			model.addAttribute("contactList", userFromDB.getContacts());
			model.addAttribute("contactBook", new ContactBook());
			return "address";
		}
	}

	@GetMapping({ "/addEmployee" })
	public String addEmployee(Locale locale, Model model, HttpSession session) {
		if (setSessionUserToModel(session, model) == null) {
			return "index";
		} else {
			User user = new User();
			user.setEmployeeId(this.userService.getMaxId() + 1);
			model.addAttribute("employee", user);
			return "addEmployee";
		}
	}

	@GetMapping({ "/deleteEmployee" })
	public String deleteEmployee(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		model.addAttribute("employee", new User());
		return "deleteEmployee";
	}

	@PostMapping({ "/deleteEmployee" })
	public String deleteEmployee(@ModelAttribute("employee") User user, Locale locale, Model model,
			HttpSession session) {
		this.setSessionUserToModel(session, model);
		String message = "";
		if (user.getUserName().equalsIgnoreCase("admin")) {
			message = "You don't have sufficient privilege to delete \"admin\" ";
		}

		Integer id = this.userService.getIdByUserName(user.getUserName());
		if (id == null) {
			message = "Userid: " + user.getUserName() + " Doesnot exist.";
		} else {
			this.userService.delete(id);
			message = "Employee Deleted Successfully.";
		}

		model.addAttribute("employeeDeletedMessage", message);
		return "deleteEmployee";
	}

	@GetMapping({ "/banUser" })
	public String banUser(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		model.addAttribute("employee", new User());
		return "banUser";
	}

	@PostMapping({ "/banUser" })
	public String banUser(@ModelAttribute("employee") User user, Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		String message = "";
		if (user.getUserName().equalsIgnoreCase("admin")) {
			message = "You don't have sufficient privilege to ban \"admin\" ";
		}

		Integer id = this.userService.getIdByUserName(user.getUserName());
		if (id == null) {
			message = "Userid: " + user.getUserName() + " Doesnot exist.";
		} else {
			this.userService.banUser(id);
			message = "Employee Banned Successfully.";
		}

		model.addAttribute("message", message);
		return "banUser";
	}

	@GetMapping({ "/activateUser" })
	public String activateUser(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		model.addAttribute("employee", new User());
		return "activateUser";
	}

	@PostMapping({ "/activateUser" })
	public String activateUser(@ModelAttribute("employee") User user, Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		String message = "";
		if (user.getUserName().equalsIgnoreCase("admin")) {
			message = "You don't have sufficient privilege to ban \"admin\" ";
		}

		Integer id = this.userService.getIdByUserName(user.getUserName());
		if (id == null) {
			message = "Userid: " + user.getUserName() + " Doesnot exist.";
		} else {
			this.userService.activateUser(id);
			message = "User Activated Successfully.";
		}

		model.addAttribute("message", message);
		return "activateUser";
	}

	@PostMapping({ "/saveEmployee" })
	public String saveEmployee(Locale locale, @ModelAttribute("employee") User user, Model model, HttpSession session) {
		user.setActivate("n");
		this.userService.save(user);
		this.setSessionUserToModel(session, model);
		model.addAttribute("employeeAddedMessage", "Employee Added Successfully.");
		return "addEmployee";
	}

	@GetMapping({ "/writeMessage" })
	public String writeMessage(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		model.addAttribute("message", new Message());
		model.addAttribute("toUserList", this.userService.userList());
		return "writeMessage";
	}

	@GetMapping({ "/readMessage" })
	public String readMessage(Locale locale, Model model, HttpSession session) {
		User myUser = this.setSessionUserToModel(session, model);
		Object[] params = new Object[] { myUser.getId() };
		List<Message> messageList = this.messageService.getListByQuery("from Message m where m.toUser=?", params);
		Iterator var7 = messageList.iterator();

		while (var7.hasNext()) {
			Message message = (Message) var7.next();
			message.setFromUserName(this.userService.findById(message.getFromUser()).getUserName());
			message.setToUserName(this.userService.findById(message.getToUser()).getUserName());
		}

		model.addAttribute("messageList", messageList);
		return "readMessage";
	}

	@GetMapping({ "/viewMessageDetails" })
	public String viewMessageDetails(@RequestParam("id") Integer id, Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		Message message2 = this.messageService.findById(id);
		message2.setFromUserName(this.userService.findById(message2.getFromUser()).getUserName());
		message2.setToUserName(this.userService.findById(message2.getToUser()).getUserName());
		model.addAttribute("message", message2);
		return "viewMessageDetails";
	}

	@GetMapping({ "/deleteMessage" })
	public String deleteMessage(@RequestParam("id") Integer id, Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		this.messageService.delete(id);
		return "offline";
	}

	@PostMapping({ "/saveMessage" })
	public String saveMessage(Locale locale, @ModelAttribute("message") Message message, Model model,
			HttpSession session) {
		User myUser = this.setSessionUserToModel(session, model);
		message.setTime(new Date());
		message.setFromUser(myUser.getId());
		this.messageService.addMessage(message);
		return "offline";
	}

	@GetMapping({ "/myRoom" })
	public String myRoom(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		return "myRoom";
	}

	@GetMapping({ "/createRoom" })
	public String createRoom(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		model.addAttribute("chatRoom", new ChatRoom());
		return "createRoom";
	}

	@GetMapping({ "/offline" })
	public String offline(HttpSession session, Model model) {
		this.setSessionUserToModel(session, model);
		return "offline";
	}

	@PostMapping({ "/createChatRoom" })
	public String createChatRoom(Locale locale, Model model, HttpSession session,
			@ModelAttribute("chatRoom") ChatRoom chatRoom) {
		User myUser = this.setSessionUserToModel(session, model);
		chatRoom.setOwner(myUser);
		this.chatRoomService.addChatRoom(chatRoom);
		return "successCreateChatRoom";
	}

	@GetMapping({ "/loginRoom" })
	public String loginRoom(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		model.addAttribute("chatRoom", new ChatRoom());
		return "loginRoom";
	}

	@PostMapping({ "/loginChatRoom" })
	public String loginChatRoom(Locale locale, Model model, HttpSession session,
			@ModelAttribute("chatRoom") ChatRoom chatRoom, BindingResult result) {
		this.setSessionUserToModel(session, model);
		String returnString = "";
		ChatRoom chatRoomFromDB = null;
		if (result.hasErrors()) {
			model.addAttribute("error", result.getAllErrors());
			model.addAttribute("chatRoom", new ChatRoom());
			returnString = "loginRoom";
		}

		if ((chatRoomFromDB = this.chatRoomService.findByRoomAndKey(chatRoom)) != null) {
			User myUser = (User) session.getAttribute("user");
			session.setAttribute("chatRoomSessionObj", chatRoomFromDB);
			model.addAttribute("chatmessages", this.getChatMessages(chatRoom));
			this.buildChatRoom(myUser.getUserName(), model, session);
			returnString = "chatRoom";
		} else {
			model.addAttribute("error", "Please enter valid Chatroom Details!!");
			returnString = "loginRoom";
		}

		return returnString;
	}

	private void buildChatRoom(String userName, Model model, HttpSession session) {
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setUserName(userName);
		ChatRoom chatRoom = (ChatRoom) session.getAttribute("chatRoomSessionObj");
		model.addAttribute("chatMessage", chatMessage);
		ChatRoom chatRoomFromDB = this.chatRoomService.findByRoomAndKey(chatRoom);
		model.addAttribute("chatmessages", this.getChatMessages(chatRoomFromDB));
	}

	@GetMapping({ "/chatRoom" })
	public String chatRoom(Locale locale, @ModelAttribute("chatMessage") ChatMessage chatMessage, Model model,
			HttpSession session) {
		User user = this.setSessionUserToModel(session, model);
		this.buildChatRoom(user.getUserName(), model, session);
		return "chatRoom";
	}

	@PostMapping({ "/sendChatMessage" })
	public String sendChatMessage(Locale locale, @ModelAttribute("chatMessage") ChatMessage chatMessage, Model model,
			HttpServletRequest servletRequest, HttpSession session) {
		logger.info("***************inside sendChatMessage()*************");
		User user = this.setSessionUserToModel(session, model);
		chatMessage.setMessageBody(user.getUserName() + " : " + chatMessage.getMessageBody());
		chatMessage.setTime(new Date());
		ChatRoom chatRoom = (ChatRoom) session.getAttribute("chatRoomSessionObj");
//		chatMessage.setChatRoom(chatRoom);

		// save file
		List<MultipartFile> files = chatMessage.getFile();
		System.out.println("files.size()" + files.size());
		List<String> fileNames = new ArrayList<String>();
		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				

				// File imageFile = new
				// File(servletRequest.getServletContext().getRealPath("../resources/images"),
				// fileName);

				File imageFile = null;
				if (!fileName.equals("")) {
					fileNames.add(fileName);
					imageFile = new File("C:\\GSP\\tmp", fileName);
					try {
						multipartFile.transferTo(imageFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		// clear file list
		chatMessage.getFile().clear();

		this.chatRoomService.saveChatRoomMessage(chatRoom, chatMessage);
		this.buildChatRoom(user.getUserName(), model, session);
		return "chatRoom";
	}

	private String getChatMessages(ChatRoom chatRoom) {
		StringBuilder chatmessages = new StringBuilder();
		if (!chatRoom.getChatRoomMessages().isEmpty()) {
			Iterator var3 = chatRoom.getChatRoomMessages().iterator();

			while (var3.hasNext()) {
				ChatMessage chatMessage = (ChatMessage) var3.next();
				chatmessages.append(chatMessage.getMessageBody());
				chatmessages.append("\n");
			}
		}

		return chatmessages.toString();
	}

	@RequestMapping(value = { "/addDeleteContact" }, params = { "addContact" }, method = { RequestMethod.POST })
	public String addContactUI(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		model.addAttribute("contactBook", new ContactBook());
		return "addContact";
	}

	@RequestMapping(value = { "/addDeleteContact" }, params = { "deleteContact" }, method = { RequestMethod.POST })
	public String deleteContact(Locale locale, @ModelAttribute("contactBook") ContactBook contact, Model model,
			HttpSession session) {
		User myUser = this.setSessionUserToModel(session, model);
		this.userService.deleteContacts(myUser, contact.getSelectedContacts());
		session.setAttribute("user", myUser);
		return "redirect:/address";
	}

	@PostMapping({ "/addContact" })
	public String addContact(Locale locale, Model model, HttpSession session,
			@ModelAttribute("contactBook") ContactBook contact) {
		User myUser = this.setSessionUserToModel(session, model);
		this.userService.addContact(myUser, contact);
		session.setAttribute("user", myUser);
		return "redirect:/address";
	}

	@GetMapping({ "/login" })
	public String home(Locale locale, Model model) {
		return "index";
	}

	@GetMapping({ "/addLibrarianForm" })
	public String addLibrarianForm(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		model.addAttribute("myUser", new User());
		return "addLibrarianForm";
	}

	@GetMapping({ "/myProfile" })
	public String myProfile(Locale locale, Model model, HttpSession session) {
		User user = this.setSessionUserToModel(session, model);
		model.addAttribute("myUser", this.userService.findById(user.getId()));
		return "myProfile";
	}

	@GetMapping({ "/userChangePassword" })
	public String userChangePassword(Locale locale, Model model, HttpSession session) {
		User user = this.setSessionUserToModel(session, model);
		model.addAttribute("myUser", this.userService.findById(user.getId()));
		model.addAttribute("resultMessage", "");
		return "userChangePassword";
	}

	@GetMapping({ "/adminChangePassword" })
	public String adminChangePassword(Locale locale, Model model, HttpSession session) {
		User user = this.setSessionUserToModel(session, model);
		model.addAttribute("myUser", this.userService.findById(user.getId()));
		model.addAttribute("resultMessage", "");
		return "adminChangePassword";
	}

	@PostMapping({ "/updatePassword" })
	public String updatePassword(@ModelAttribute("myUser") @Valid User myUser, Locale locale, Model model,
			HttpSession session) {
		String resultMessage = "";
		User user = this.userService.updatePassword(myUser);
		if (user == null) {
			resultMessage = "UserId: " + myUser.getUserName() + " doesn't exist!!";
			model.addAttribute("resultMessage", resultMessage);
		} else {
			session.setAttribute("myUser", user);
			resultMessage = "Password changed Successfully.";
			model.addAttribute("resultMessage", resultMessage);
			session.setAttribute("user", user);
		}

		this.setSessionUserToModel(session, model);
		return this.returnPasswordPage(myUser);
	}

	private String returnPasswordPage(User user) {
		return user.getUserName().equals("admin") ? "adminChangePassword" : "userChangePassword";
	}

	@GetMapping({ "/userStatus" })
	public String userStatus(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		return "userStatusForm";
	}

	@PostMapping({ "/getUserStatus" })
	public String getUserStatus(@ModelAttribute("myUser") @Valid User user, Locale locale, Model model,
			HttpSession session) {
		String message = "";
		User userFromSession = this.setSessionUserToModel(session, model);
		if (!userFromSession.getUserName().equals("admin") && user.getUserName().equalsIgnoreCase("admin")) {
			message = "You don't have sufficient privilege!! ";
			model.addAttribute("resultMessage", message);
			return "userStatusForm";
		} else {
			Integer id = this.userService.getIdByUserName(user.getUserName());
			if (id == null) {
				message = "Userid: " + user.getUserName() + " Doesnot exist.";
			} else {
				User userFromDB = this.userService.findById(id);
				userFromDB.setStatus(this.getOnlineStatus(userFromDB));
				model.addAttribute("resultUser", userFromDB);
				model.addAttribute("loginDate", userFromDB.getLoginTime().toString().split(" ")[0]);
				String loginTime = userFromDB.getLoginTime().toString().split(" ")[1].substring(0, 8);
				model.addAttribute("loginTime", loginTime);
				message = null;
			}

			model.addAttribute("resultMessage", message);
			return "userStatus";
		}
	}

	@PostMapping({ "/editLibrarianForm" })
	public String editLibrarianForm(@ModelAttribute("myUser") User myUser, Locale locale, Model model) {
		model.addAttribute("myUser", this.userService.findById(myUser.getId()));
		return "editLibrarianForm";
	}

	@PostMapping({ "/deleteLibrarianForm" })
	public String deleteLibrarianForm(@ModelAttribute("myUser") User myUser, Locale locale, Model model) {
		this.userService.delete(myUser.getId());
		model.addAttribute("librarianList", this.userService.userList());
		return "viewLibrarian";
	}

	@GetMapping({ "/getEmployeeList" })
	public String getEmployeeList(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		model.addAttribute("employeeList", this.userService.userList());
		return "viewEmployeeList";
	}

	@GetMapping({ "/viewOnlineEmployeeList" })
	public String viewEmployeeList(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		List<User> employeeList = this.userService.userList();
		Iterator it = employeeList.iterator();

		while (it.hasNext()) {
			User user = (User) it.next();
			if (user.getLogoutTime() != null) {
				it.remove();
			}
		}

		model.addAttribute("employeeList", employeeList);
		return "viewEmployeeList";
	}

	@PostMapping({ "/updateProfile" })
	public String updateProfile(@ModelAttribute("myUser") @Valid User myUser, Locale locale, Model model,
			HttpSession session) {
		User user = this.userService.update(myUser);
		session.setAttribute("myUser", user);
		this.setSessionUserToModel(session, model);
		return this.returnHomePage(myUser);
	}

	@GetMapping({ "/otherProfiles" })
	public String searchUserForm(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		return "otherProfilesForm";
	}

	@PostMapping({ "/searchUser" })
	public String searchUser(@ModelAttribute("myUser") @Valid User user, Locale locale, Model model,
			HttpSession session) {
		this.setSessionUserToModel(session, model);
		String message = "";
		Integer id = this.userService.getIdByUserName(user.getUserName());
		if (id == null) {
			message = "Userid: " + user.getUserName() + " Doesnot exist.";
		} else {
			User userFromDB = this.userService.findById(id);
			model.addAttribute("resultUser", userFromDB);
			message = null;
		}

		model.addAttribute("resultMessage", message);
		return "searchResult";
	}

	public String returnHomePage(User user) {
		return user.getUserName().equals("admin") ? "adminHome" : "userHome";
	}

	@GetMapping({ "/homePage" })
	public String homePage(Locale locale, Model model, HttpSession session) {
		User user = this.setSessionUserToModel(session, model);
		return this.returnHomePage(user);
	}

	@GetMapping({ "/readAdvices" })
	public String readAdvices(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		return "readAdvices";
	}

	@GetMapping({ "/statistics" })
	public String statistics(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		int offlineUsers = 0;
		int onLineUsers = 0;
		int totalRooms = 0;
		List<User> userList = this.userService.userList();
		Iterator var8 = userList.iterator();

		while (var8.hasNext()) {
			User user = (User) var8.next();
			if (user.getLogoutTime() == null) {
				++onLineUsers;
			} else {
				++offlineUsers;
			}
		}

		model.addAttribute("chatRoom", new ChatRoom());
		model.addAttribute("totalUsers", userList.size());
		model.addAttribute("onLineUsers", onLineUsers);
		model.addAttribute("offlineUsers", offlineUsers);
		model.addAttribute("totalRooms", Integer.valueOf(totalRooms));
		return "statistics";
	}

	@GetMapping({ "/userLogin" })
	public String userLogin(Locale locale, Model model, HttpSession session) {
		User user = this.setSessionUserToModel(session, model);
		return this.returnHomePage(user);
	}

	@GetMapping({ "/logo" })
	public String logo() {
		return "logo";
	}

	@GetMapping({ "/suggestions" })
	public String suggestions() {
		return "suggestions";
	}

	@PostMapping({ "/addLibrarian" })
	public String addLibrarian(@ModelAttribute("myUser") @Valid User myUser, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("error", "Add Librarian Form");
			return "addLibrarianForm";
		} else {
			this.userService.save(myUser);
			model.addAttribute("error", "Librarian registered successfully");
			return "index";
		}
	}

	@PostMapping({ "/userLogin" })
	public String login(@ModelAttribute("myUser") @Valid User myUser, BindingResult result, Model model,
			HttpSession session, ModelAndView mav) {
		String returnString = "";
		User userFromDB = null;
		if (result.hasErrors()) {
			model.addAttribute("error", result.getAllErrors());
			if (!myUser.getUserName().equals("admin")) {
				returnString = "userloginform";
			} else {
				returnString = "adminloginform";
			}
		}

		if ((userFromDB = this.userService.findByUserAndPassword(myUser)) != null) {
			if (userFromDB.getActivate().equals("y")) {
				this.userService.login(userFromDB.getId());
				session.setAttribute("user", userFromDB);
				this.setSessionUserToModel(session, model);

				if (userFromDB.getUserName().equals("admin")) {
					returnString = "adminHome";
				} else {
					returnString = "userHome";
				}
			} else {
				model.addAttribute("error", "Please activate user and try again.");
				if (!myUser.getUserName().equals("admin")) {
					returnString = "userloginform";
				} else {
					returnString = "adminloginform";
				}
			}
		} else {
			model.addAttribute("error", "Please enter valid Credentials");
			if (!myUser.getUserName().equals("admin")) {
				returnString = "userloginform";
			} else {
				returnString = "adminloginform";
			}
		}

		return returnString;
	}

	private String getOnlineStatus(User user) {
		return user.getLogoutTime() == null ? "Online" : "Offline";
	}

	@GetMapping({ "/adminHome" })
	public String adminHome(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		return "adminHome";
	}

	@GetMapping({ "/userHome" })
	public String userHome(Locale locale, Model model, HttpSession session) {
		this.setSessionUserToModel(session, model);
		return "userHome";
	}

	@GetMapping({ "/logout" })
	public String logoutAdmin(Locale locale, Model model, WebRequest request, HttpSession session,
			SessionStatus status) {
		User user = this.setSessionUserToModel(session, model);
		this.userService.logout(user.getId());
		status.setComplete();
		session.invalidate();
		return "redirect:/";
	}
}