package com.authapi.restfulauthenticationapi.dto;

import java.io.Serializable;

public class TokenDTO implements Serializable {

	private static final long serialVersionUID = 767911363639485448L;
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
