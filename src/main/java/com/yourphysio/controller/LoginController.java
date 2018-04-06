package com.yourphysio.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yourphysio.model.User;
import com.yourphysio.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET,value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/login")
	public String login(String email, String password) {
		
		try {
			User usuario = userService.userFindByEmail(email);
			if (usuario.getPassword().equals(password)) {
				return "redirect:/users";
			} else return "/login";
		} catch (Exception e) {
			return "redirect:/cadastro";
		}
	}

}
