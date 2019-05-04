package com.authapi.restfulauthenticationapi.dto;

import java.io.Serializable;

public class PhoneDTO implements Serializable {

	private static final long serialVersionUID = 7553039364992927760L;
	
	private String countryCode;
	
	private String areaCode;
	
	private String number;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneDTO() {
	}
	
	

}
