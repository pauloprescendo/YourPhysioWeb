package com.yourphysio.controllers;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yourphysio.models.User;
import com.yourphysio.services.UserService;

@RestController
public class UserController {
	
	/*	@RequestMapping("/registerUser")
	public String form() {
		return "create.html";
	}*/
	
	@Autowired
	UserService userService;
	
	//end points
	@RequestMapping(method=RequestMethod.POST, value="/users", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User userSave = userService.userRegister(user);
		return new ResponseEntity<User>(userSave, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/users", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection <User>> findAllUsers() {
		Collection<User> usersFound = userService.userFindAll(); //Spring Boot e Angular JS - Aula 01 Parte 03 #### 25:27 
		return new ResponseEntity<>( usersFound, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
		
		User userFound = userService.userFindById(id);		
		if (userFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userService.userDelete(userFound);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User userUpdated = userService.userUpdate(user);
		return new ResponseEntity<>(userUpdated, HttpStatus.OK);
	}
	

}
