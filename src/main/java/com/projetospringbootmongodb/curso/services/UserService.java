package com.projetospringbootmongodb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetospringbootmongodb.curso.domain.User;
import com.projetospringbootmongodb.curso.dto.UserDTO;
import com.projetospringbootmongodb.curso.repositories.UserRepository;
import com.projetospringbootmongodb.curso.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User insert(User user) {
		return userRepository.insert(user);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);

		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
