package br.com.ssys.authentication.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.ssys.authentication.api.security.AuthService;

@RestController
public class AuthorizationResource {

	@Autowired
	AuthService auth;
	
	@GetMapping("/authorization/{token}")
	public UsernamePasswordAuthenticationToken getAuthorization(@PathVariable String token) {
		return auth.getAuthorization(token);
	}
}