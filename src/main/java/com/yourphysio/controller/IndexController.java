package com.yourphysio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yourphysio.model.User;
import com.yourphysio.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET,value="/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/index")
	public String index(User user) {
		
		userService.userRegister(user);
		return "redirect:/index";
	}

}
