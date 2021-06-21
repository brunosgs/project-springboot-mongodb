package com.projetospringbootmongodb.curso.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetospringbootmongodb.curso.domain.User;
import com.projetospringbootmongodb.curso.dto.UserDTO;
import com.projetospringbootmongodb.curso.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> listUser = userService.findAll();
		List<UserDTO> listUserDTO = listUser.stream().map(u -> new UserDTO(u)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listUserDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = userService.findById(id);

		return ResponseEntity.ok().body(new UserDTO(user));
	}
}
