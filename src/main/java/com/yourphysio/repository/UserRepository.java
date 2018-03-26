package com.yourphysio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yourphysio.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
