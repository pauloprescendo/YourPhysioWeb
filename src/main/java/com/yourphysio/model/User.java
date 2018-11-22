package com.yourphysio.model;

import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.AssertFalse;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="users")
public class User implements UserDetails{
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue()
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String senha;
	@Column(nullable = false)
	private int age;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_exercises",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "exercise_id", referencedColumnName = "id"))
	private List<Exercise> exercises;
	private Boolean isPremium = false;
	private String cref;

	public User() {
	}
	
	public User(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.senha = user.getSenha();
		this.age = user.getAge();
	}
	
	public User(String name, String email, String senha, int age, List<Exercise> exercises) {
		super();
		this.name = name;
		this.email = email;
		this.senha = senha;
		this.age = age;
		this.exercises = exercises;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	public Boolean getPremium() {
		return isPremium;
	}

	public void setPremium(Boolean premium) {
		isPremium = premium;
	}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
