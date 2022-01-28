package br.com.ssys.user.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ssys.user.api.exceptions.ResourceNotFoundException;
import br.com.ssys.user.api.model.User;
import br.com.ssys.user.api.repository.UserRepository;
import br.com.ssys.user.api.utils.Constants;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public User findByEmail(String email) {
		Optional<User> user = repository.findByEmail(email);
		return user.orElseThrow(() -> new ResourceNotFoundException(Constants.EMAIL_NOT_FOUND + email));
	}

	public User create(User user) {
		return repository.save(user);
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}

}
