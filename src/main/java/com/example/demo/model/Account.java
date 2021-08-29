package com.example.demo.model;

import java.sql.Timestamp;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "ACCOUNT")
@Table(name = "Account")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	private String username;
	private String password;
	
	private String firstname;
	
	private String lastname;
	private Timestamp createdat;
	
	private Timestamp updatedat;
	
   	
	
	public Account() {
		
		// TODO Auto-generated constructor stub
	}

	
	public Account(long id, String username, String password,  String firstname, String lastname,
			Timestamp createdat, Timestamp updatedat) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.createdat = createdat;
		this.updatedat = updatedat;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Timestamp getCreatedat() {
		return createdat;
	}
	public void setCreatedat(Timestamp createdat) {
		this.createdat = createdat;
	}
	public Timestamp getUpdatedat() {
		return updatedat;
	}
	public void setUpdatedat(Timestamp updatedat) {
		this.updatedat = updatedat;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", createdat=" + createdat + ", updatedat="
				+ updatedat + "]";
	}
	
	

}
