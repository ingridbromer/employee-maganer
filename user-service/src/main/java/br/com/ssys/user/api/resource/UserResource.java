package br.com.ssys.user.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ssys.user.api.model.User;
import br.com.ssys.user.api.service.UserService;

@RestController
public class UserResource {

	@Autowired
	UserService service;
	
	
	@GetMapping("/user/{email}")
	public User findByEmail(@PathVariable String email) {
		return service.findByEmail(email);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@PostMapping("/user")
	public User create(@RequestBody User user) {
		return service.create(user);
	}
	
	
}
