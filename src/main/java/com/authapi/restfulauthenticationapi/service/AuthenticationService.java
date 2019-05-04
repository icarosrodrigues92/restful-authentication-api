package com.authapi.restfulauthenticationapi.service;

import com.authapi.restfulauthenticationapi.dto.PersonDTO;
import com.authapi.restfulauthenticationapi.model.Person;

public interface AuthenticationService {

	Person findPersonById(Long id);
	
	Person save(PersonDTO personDto);

	Person findPersonByCredentials(String email, String password);

	Person findPersonByEmail(String email);
}
