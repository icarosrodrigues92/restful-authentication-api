package com.authapi.restfulauthenticationapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authapi.restfulauthenticationapi.dto.PersonDTO;
import com.authapi.restfulauthenticationapi.model.Person;
import com.authapi.restfulauthenticationapi.model.Phone;
import com.authapi.restfulauthenticationapi.repository.AuthenticationRepository;
import com.authapi.restfulauthenticationapi.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	AuthenticationRepository repository;
	
	@Override
	public Person findPersonById(Long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public Person findPersonByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public Person save(PersonDTO personDto) {

		Person person = new Person();
		person.setFirstName(personDto.getFirstName());
		person.setLastName(personDto.getLastName());
		person.setEmail(personDto.getEmail());
		person.setPassword(personDto.getPassword());
		Phone phone = new Phone();
		phone.setAreaCode(personDto.getPhone().getAreaCode());
		phone.setCountryCode(personDto.getPhone().getCountryCode());
		phone.setNumber(personDto.getPhone().getNumber());
		person.setPhone(phone);
		
		return repository.save(person);
	}

	@Override
	public Person findPersonByCredentials(String email, String password) {
		return repository.findByEmailAndPassword(email,password);
	}
}
