package com.yourphysio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yourphysio.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmailIgnoreCase(String email);

}
