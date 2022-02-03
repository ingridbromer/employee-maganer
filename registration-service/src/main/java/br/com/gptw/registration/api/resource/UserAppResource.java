package br.com.gptw.registration.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.gptw.registration.api.model.AppUser;
import br.com.gptw.registration.api.service.AppUserService;

@RestController
public class UserAppResource {

	@Autowired
	AppUserService service;

	
	@GetMapping("/user/{email}")
	public AppUser findByEmail(@PathVariable String email) {
		return service.findByEmail(email);
	}
	
}
