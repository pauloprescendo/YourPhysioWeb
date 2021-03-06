package com.yourphysio.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.yourphysio.model.User;
import com.yourphysio.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.POST, value="/users", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		user.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
		User userSave = userService.userRegister(user);
		return new ResponseEntity<>(userSave, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/users", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection <User>> findAllUsers() {
		Collection<User> usersFound = userService.userFindAll();
		return new ResponseEntity<>( usersFound, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, value="/users/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findUser(@PathVariable Long id) {

		User userFound = userService.userFindById(id);
		if (userFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>( userFound, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Long id) {
		
		User userFound = userService.userFindById(id);
		if (userFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userService.userDelete(userFound);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		user.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
		User userUpdated = userService.userUpdate(user);
		return new ResponseEntity<>(userUpdated, HttpStatus.OK);
	}
	
}
