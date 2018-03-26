package com.yourphysio.services;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yourphysio.models.User;
import com.yourphysio.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User userRegister(User user) {
		return userRepository.save(user);
	}
	
	public Collection<User> userFindAll(){
		return userRepository.findAll();
	}
	
	public void userDelete(User user) {
		userRepository.delete(user);
	}
	
	public User userFindById(Integer id) {
		return userRepository.getOne(id);
	}
	
	public User userUpdate(User user) {
		return userRepository.save(user);
	}

}
