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
public class IndexController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET,value="/")
	public String index(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal.equals("anonymousUser")) model.addAttribute("principalUser", principal);
		else model.addAttribute("nomePrincipal",((User) principal).getName());
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/index")
	public String index(User user) {
		
		userService.userRegister(user);
		return "redirect:/index";
	}

}
