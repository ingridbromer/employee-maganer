package br.com.gptw.authentication.api.restUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.gptw.authentication.api.model.dto.UserDTO;

@Component
public class RestUser {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	
	@Value("${service.registration.baseUrl}")
	private String baseUrl;

	public UserDTO verifyClient(String email) {
		return restTemplate.getForObject(baseUrl + "user/" + email, UserDTO.class);
	}
}
