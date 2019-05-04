package com.authapi.restfulauthenticationapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="phone_sequence")
	@SequenceGenerator(name="phone_sequence", sequenceName="phone_seq")
	private Long id;
	
	@Column(name = "country_code", nullable=false)
	private String countryCode;
	
	@Column(name = "area_code", nullable=false)
	private String areaCode;
	
	@Column(name = "number", nullable=false)
	private String number;
	
	public Long getId() {
		return id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public String getNumber() {
		return number;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
