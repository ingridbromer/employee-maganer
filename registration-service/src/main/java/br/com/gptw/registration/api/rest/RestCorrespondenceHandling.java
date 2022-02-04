package br.com.gptw.registration.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.gptw.registration.api.model.SmsRequest;


@Component
public class RestCorrespondenceHandling {
	
	@Autowired
	RestTemplate restTemplate;

	@Value("${service.correspondenceHandling.baseUrl}")
	private String baseUrl;
	
	public SmsRequest PostSms(String phoneNumber, String message) {
		return restTemplate.postForObject(baseUrl, "sms/" + phoneNumber + message, SmsRequest.class);
	}
}
