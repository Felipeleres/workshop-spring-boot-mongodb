package com.felipeleres.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipeleres.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

}
