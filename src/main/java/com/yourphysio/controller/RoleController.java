package com.yourphysio.controller;

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

import com.yourphysio.model.Role;
import com.yourphysio.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	RoleService roleService;

	@RequestMapping(value = "/role", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Role>> listar() {
		Collection<Role> rolesFound = roleService.findAllRole();
		return new ResponseEntity<>(rolesFound, HttpStatus.OK);
	}

	@RequestMapping(value = "/role", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Role> salvar(@RequestBody Role role) {
		Role roleSave = roleService.registerRole(role);
		return new ResponseEntity<>(roleSave, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/role", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Role> editar(@RequestBody Role role) {
		Role roleUpdated = roleService.updateRole(role);
		return new ResponseEntity<>(roleUpdated, HttpStatus.OK);
	}

	@RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Role> deletar(@PathVariable Integer id) {
		Role roleFound = roleService.findByIdRole(id);
		if (roleFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		roleService.deleteRole(roleFound);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
