package com.info.controller;

import com.info.model.User;
import com.info.service.UserService;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/"})
public class UserController {
   @Autowired
   private UserService userService;

   @GetMapping({"/home"})
   public String home(Locale locale, Model model) {
      model.addAttribute("myMessage", "Home page");
      return "home";
   }

   @ModelAttribute("myUser")
   public User formBackingObject() {
      return new User();
   }

   @GetMapping({"/registerUser"})
   public String addUser(Locale locale, Model model) {
      model.addAttribute("myMessage", "Add User Form");
      return "addUser";
   }

   @PostMapping({"/saveUser"})
   public String saveUser(@ModelAttribute("myUser") @Valid User myUser, BindingResult result, Model model) {
      if (result.hasErrors()) {
         model.addAttribute("myMessage", "Add User Form");
         return "addUser";
      } else {
         this.userService.save(myUser);
         model.addAttribute("myMessage", "User registered successfully");
         return "index";
      }
   }

   @GetMapping({"/logoutLibrarian"})
   public String logoutForm(Locale locale, Model model) {
      model.addAttribute("myMessage", "You have successfully logged out, Please Login again");
      return "librarianloginform";
   }
}