package com.projetospringbootmongodb.curso.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetospringbootmongodb.curso.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
