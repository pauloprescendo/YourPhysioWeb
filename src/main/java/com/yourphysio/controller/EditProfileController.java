package com.yourphysio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yourphysio.model.User;
import com.yourphysio.service.UserService;

@Controller
public class EditProfileController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET, value="/edit")
	public String edit(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("nameInput",((User) principal).getName());
		model.addAttribute("emailInput",((User) principal).getEmail());
		model.addAttribute("ageInput",((User) principal).getAge());
		return "edit";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/edit")
	public String edit(User user) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (user.getName().isEmpty()) user.setName(((User) principal).getName());
		if (user.getEmail().isEmpty()) user.setEmail(((User) principal).getEmail());
		if (user.getAge() == 0) user.setAge(((User) principal).getAge());
		if (user.getSenha().isEmpty()){
			user.setSenha(((User) principal).getSenha());
		} else {
			user.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
		}
		user.setId(((User) principal).getId());
		userService.userUpdate(user);
		return "edit";
	}

}
