package br.com.gptw.registration.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.gptw.registration.api.mapper.UserNamePasswordMapper;
import br.com.gptw.registration.api.model.dto.UserNamePasswordDTO;

@Component
public class RestAuthorization {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UserNamePasswordMapper mapper;

	@Value("${service.authentication.baseUrl}")
	private String baseUrl;

	public UsernamePasswordAuthenticationToken getAuthorization(String username) {
		return mapper.toEntity(restTemplate.getForObject(baseUrl + "authentication/" + username, UserNamePasswordDTO.class));
	}
}
