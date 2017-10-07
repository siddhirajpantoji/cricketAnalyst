package com.cricketanalyse.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AuditParams {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull ( message ="USerName cannot be null") 
	private String userName;
	
	@NotNull ( message = " Password Cannot be null")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public User( String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
	}	
}