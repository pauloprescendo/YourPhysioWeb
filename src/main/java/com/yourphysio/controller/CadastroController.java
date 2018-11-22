package com.yourphysio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yourphysio.model.User;
import com.yourphysio.service.UserService;

@Controller
public class CadastroController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET,value="/cadastro")
	public String cadastro() {
		return "cadastro";
	}
	@RequestMapping(method=RequestMethod.GET,value="/cadastroInstrutor")
	public String cadastroInstrutor() {
		return "cadastroInstrutor";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/cadastro")
	public String cadastro(User user) {
		user.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
		userService.userRegister(user);
		return "redirect:/login";
	}

}
