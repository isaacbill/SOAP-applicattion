package com.supermart.model;

public class User {
	private String username;
	private String password;
	private String confirmpwd;
	
	public User() {
		
	}
	public User(String username, String password, String confirmpwd) {
		this.username = username;
		this.password = password;
		this.confirmpwd = confirmpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpwd() {
		return confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", confirmpwd=" + confirmpwd + "]";
	}
	
	}
