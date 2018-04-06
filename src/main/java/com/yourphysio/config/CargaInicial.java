/*package com.yourphysio.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.yourphysio.model.Role;
import com.yourphysio.model.User;
import com.yourphysio.repository.RoleRepository;
import com.yourphysio.repository.UserRepository;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<Role> roles = roleRepository.findAll();
		
		if (roles.isEmpty()) {
			roleRepository.save(new Role("ROLE_ADMIN"));
			
			Role role = roleRepository.findByName("ROLE_ADMIN");
			
			List<Role> roleUser = new ArrayList<>();
			roleUser.add(role);
			userRepository.save(new User("Paulo","admin","123", roleUser));
		}
	}

}
*/