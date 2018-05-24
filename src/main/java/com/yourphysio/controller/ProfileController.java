package com.yourphysio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yourphysio.model.User;
import com.yourphysio.service.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET, value="/profile")
	public String profile(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("nomePrincipal", ((User) principal).getName());
		model.addAttribute("emailPrincipal", ((User) principal).getEmail());
		return "profile";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/profile")
	public String profile(User user) {
		return "profile";
	}

}
