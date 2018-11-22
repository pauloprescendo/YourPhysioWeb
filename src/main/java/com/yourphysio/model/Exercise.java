package com.yourphysio.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exercises")
public class Exercise {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String category;
	@ManyToMany(mappedBy = "exercises")
	private List<User> users;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Exercise(){
	}

	public Exercise(String name, String category) {
		this.name = name;
		this.category = category;
	}

	public Exercise (Exercise exercise) {
		this.name = exercise.getName();
		this.category = exercise.getCategory();
	}
}
