package br.com.gptw.registration.api.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gptw.registration.api.model.RegistrationRequest;
import br.com.gptw.registration.api.service.RegistrationService;
import lombok.AllArgsConstructor;

@RestController
//EndPoint to requisitions HTTP
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationResource {
	
	 private final RegistrationService registrationService;

	    @PostMapping
	    public String register(@RequestBody RegistrationRequest request) {
	        return registrationService.register(request);
	    }

	    @GetMapping(path = "confirm")
	    public String confirm(@RequestParam("token") String token) {
	        return registrationService.confirmToken(token);
	    }
	    
	    


}
