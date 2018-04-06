package com.yourphysio.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourphysio.model.Role;
import com.yourphysio.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	public Role registerRole(Role role) {
		return roleRepository.save(role);
	}
	
	public Collection<Role> findAllRole(){
		return roleRepository.findAll();
	}
	
	public void deleteRole(Role role) {
		roleRepository.delete(role);
	}
	
	public Role findByIdRole(Integer id) {
		return roleRepository.getOne(id);
	}
	
	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}

}
