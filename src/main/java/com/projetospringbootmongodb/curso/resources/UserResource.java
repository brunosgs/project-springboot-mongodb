package com.projetospringbootmongodb.curso.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetospringbootmongodb.curso.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User user = new User("1", "Maria Brown", "maria@gmail.com");
		User user2 = new User("2", "Alex Green", "alex@gmail.com");
		List<User> listUser = new ArrayList<>();

		listUser.addAll(Arrays.asList(user, user2));

		return ResponseEntity.ok().body(listUser);
	}
}
