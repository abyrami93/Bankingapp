package com.example.demo.model;

public class Accountdetails {
	
	private String username;
	private String password;
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
	

	public Accountdetails() {
		
		// TODO Auto-generated constructor stub
	}
	public Accountdetails(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Accountdetails [username=" + username + ", password=" + password + "]";
	}
	

}
