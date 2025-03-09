package com.felipeleres.workshopmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeleres.workshopmongo.domain.Post;
import com.felipeleres.workshopmongo.repository.PostRepository;
import com.felipeleres.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Post user = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não econtrado"));
		return user;
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 *60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}

}
