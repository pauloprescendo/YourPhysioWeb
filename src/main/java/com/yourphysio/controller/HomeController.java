package com.yourphysio.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yourphysio.model.User;

@Controller
public class HomeController {

	@RequestMapping(method=RequestMethod.GET, value="/home")
	public String home(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("nomePrincipal",((User) principal).getName());
		return "home";
	}

	@RequestMapping(method=RequestMethod.POST, value="/home")
	public String home(User user) {
		return "home";
	}

}
