package com.authapi.restfulauthenticationapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="person_sequence")
	@SequenceGenerator(name="person_sequence", sequenceName="person_seq")
	private Long id;
	
	@Column(name = "first_name", nullable=false)
	private String firstName;
	
	@Column(name = "last_name", nullable=false)
	private String lastName;
	
	@Column(name = "email", unique=true, nullable=false)
	private String email;
	
	@Column(name = "password", nullable=false)
	private String password;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "phone_id")
	private Phone phone;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public Phone getPhone() {
		return phone;
	}
	public Long getId() {
		return id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
}
