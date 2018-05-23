package com.yourphysio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yourphysio.model.User;
import com.yourphysio.service.UserService;

@Controller
public class ExercisesController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET, value="/exercises")
	public String exercises() {
		return "exercises";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/exercises")
	public String exercises(User user) {
		return "exercises";
	}

}
