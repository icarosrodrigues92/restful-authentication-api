package com.authapi.restfulauthenticationapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authapi.restfulauthenticationapi.model.Person;

@Repository
public interface AuthenticationRepository extends JpaRepository<Person, Long> {

	Person findByEmailAndPassword(String email, String password);

	Person findByEmail(String email);

}
