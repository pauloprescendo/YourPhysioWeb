package com.yourphysio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yourphysio.model.User;
import com.yourphysio.service.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET, value="/profile")
	public String profile() {
		return "profile";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/profile")
	public String profile(User user) {
		return "profile";
	}

}
