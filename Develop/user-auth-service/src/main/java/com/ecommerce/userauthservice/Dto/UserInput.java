package com.ecommerce.userauthservice.Dto;

public class UserInput {

	private String userName;

	private String email;

	public UserInput() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
