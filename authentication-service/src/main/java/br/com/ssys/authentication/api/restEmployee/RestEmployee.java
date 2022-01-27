package br.com.ssys.authentication.api.restEmployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.ssys.authentication.api.model.dto.EmployeeDTO;

@Component
public class RestEmployee {
	@Autowired
	private RestTemplate restTemplate;

	@Value("${service.employee.baseUrl}")
	private String baseUrl;

	public EmployeeDTO verifyEmployee(String email) {
		return restTemplate.getForObject(baseUrl + "user/" + email, EmployeeDTO.class);
	}
}
