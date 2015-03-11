package edu.fullerton.ecs.cpsc476.dhavalkpatel.derp_app_spring.model;

import java.util.List;


public class User {
	private String firstName;
    private String lastname;
    private String email;
    private String password;
    private List<User> users;
  
    
	public void setUser(String firstName, String lastname, String email,
			String password, List<User> users) {
		//super();
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.users = users;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	    
}
