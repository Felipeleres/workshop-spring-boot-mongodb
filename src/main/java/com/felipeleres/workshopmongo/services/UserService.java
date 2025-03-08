package com.felipeleres.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeleres.workshopmongo.domain.User;
import com.felipeleres.workshopmongo.dto.UserDTO;
import com.felipeleres.workshopmongo.repository.UserRepository;
import com.felipeleres.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		User user = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não econtrado"));
		return user;
		}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
	
	}


