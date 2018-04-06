package com.yourphysio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yourphysio.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	//Role findByName(String string);

}
