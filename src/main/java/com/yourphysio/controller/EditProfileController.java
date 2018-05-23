package com.yourphysio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yourphysio.model.User;
import com.yourphysio.service.UserService;

@Controller
public class EditProfileController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET, value="/edit")
	public String edit() {
		return "edit";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/edit")
	public String edit(User user) {
		return "edit";
	}

}
