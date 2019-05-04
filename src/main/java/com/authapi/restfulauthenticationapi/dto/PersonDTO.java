package com.authapi.restfulauthenticationapi.dto;

import java.io.Serializable;

public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 8181477198241026184L;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private PhoneDTO phone;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public PhoneDTO getPhone() {
		return phone;
	}

	public void setPhone(PhoneDTO phone) {
		this.phone = phone;
	}
	
	public PersonDTO() {
	}
	
}
