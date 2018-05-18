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
	
	@RequestMapping(method=RequestMethod.GET, path="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/login")
	public String login(String email, String senha) {
		
		try {
			User usuario = userService.userFindByEmail(email);
			if (usuario.getSenha().equals(senha)) {
				return "redirect:/home";
			} else return "/login";
		} catch (Exception e) {
			return "redirect:/cadastro";
		}
	}

}
