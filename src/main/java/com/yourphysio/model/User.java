package com.yourphysio.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.yourphysio.model.Role;

@Entity
public class User{
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String email;
	private String password;
	
//	@OneToMany(mappedBy="user")
//	private List<Role> roles;
	
	public User() {
	}
	
	public User(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		//this.roles = user.getRoles();
	}
	
	

	public User(String name, String email, String password) { //, List<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		//this.roles = roles;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	/*public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}*/

}
