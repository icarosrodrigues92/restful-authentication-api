package com.authapi.restfulauthenticationapi.controller;



import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.authapi.restfulauthenticationapi.dto.PersonDTO;
import com.authapi.restfulauthenticationapi.dto.TokenDTO;
import com.authapi.restfulauthenticationapi.model.Person;
import com.authapi.restfulauthenticationapi.responses.Response;
import com.authapi.restfulauthenticationapi.service.AuthenticationService;
import com.authapi.restfulauthenticationapi.utils.TokenProvider;

@RestController
public class AuthenticationController {
	
	@Autowired
	AuthenticationService authenticationService;

	@PostMapping(path = "/signup")
	public ResponseEntity<Response<TokenDTO>> signUp(@Valid @RequestBody PersonDTO personDto) {
		
		Response<TokenDTO> retorno = new Response<TokenDTO>();
		try {
			if (authenticationService.findPersonByEmail(personDto.getEmail()) == null) {
				TokenDTO token = new TokenDTO();
				Person person = this.authenticationService.save(personDto);
				token.setToken(TokenProvider.createToken(person.getId().toString()));
				retorno.setData(token);
				
				return new ResponseEntity<Response<TokenDTO>>(retorno, HttpStatus.OK);
			} else {
				retorno.getErrors().add("E-mail already exists");
				return new ResponseEntity<Response<TokenDTO>>(retorno, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			retorno.getErrors().add("Missing Fields");
			return new ResponseEntity<Response<TokenDTO>>(retorno, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(path = "/signin")
	public ResponseEntity<Response<TokenDTO>> signIn(@Valid @RequestBody PersonDTO personDto) {
		
		Response<TokenDTO> retorno = new Response<TokenDTO>();
		try {
			if (personDto.getEmail().isEmpty() || personDto.getPassword().isEmpty()) {
				throw new Exception();
			}
			TokenDTO token = new TokenDTO();
			Person person = authenticationService.findPersonByCredentials(personDto.getEmail(), personDto.getPassword());
			if (person == null) {
				retorno.getErrors().add("Invalid e-mail or password");
				return new ResponseEntity<Response<TokenDTO>>(retorno, HttpStatus.BAD_REQUEST);
			}
			token.setToken(TokenProvider.createToken(person.getId().toString()));
			retorno.setData(token);
			
			return new ResponseEntity<Response<TokenDTO>>(retorno, HttpStatus.OK);
		
		} catch (Exception e) {
			retorno.getErrors().add("Missing fields");
			return new ResponseEntity<Response<TokenDTO>>(retorno, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(path = "/me")
	public ResponseEntity<Response<PersonDTO>> buscar(@Valid @RequestHeader String token) {
		
		Response<PersonDTO> retorno = new Response<PersonDTO>();
		try {
			
			String personId = TokenProvider.decodeToken(token).getBody().getSubject();
			Person person = authenticationService.findPersonById(Long.parseLong(personId));
			ModelMapper modelMapper = new ModelMapper();
			PersonDTO dto = modelMapper.map(person, PersonDTO.class);
			retorno.setData(dto);
			
			return new ResponseEntity<Response<PersonDTO>>(retorno, HttpStatus.OK);
		} catch (Exception e) {
			retorno.getErrors().add("Unauthorized");
			return new ResponseEntity<Response<PersonDTO>>(retorno, HttpStatus.BAD_REQUEST);
		}
	}
	
}
