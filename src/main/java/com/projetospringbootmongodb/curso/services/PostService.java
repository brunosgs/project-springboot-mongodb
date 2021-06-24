package com.projetospringbootmongodb.curso.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetospringbootmongodb.curso.domain.Post;
import com.projetospringbootmongodb.curso.repositories.PostRepository;
import com.projetospringbootmongodb.curso.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);

		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

//	public List<Post> findByTitle(String text) {
//		return postRepository.findByTitleContainingIgnoreCase(text);
//	}

	public List<Post> findByTitle(String text) {
		return postRepository.searchTitle(text);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);

		return postRepository.fullSearch(text, minDate, maxDate);
	}
}
