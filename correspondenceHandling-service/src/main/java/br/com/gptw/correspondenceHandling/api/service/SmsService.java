package br.com.gptw.correspondenceHandling.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.gptw.correspondenceHandling.api.utils.sms.SmsSender;

@org.springframework.stereotype.Service
public class SmsService {

	private final SmsSender smsSender;

	@Autowired
	public SmsService(@Qualifier("twilio") TwilioSmsService smsSender) {
		this.smsSender = smsSender;
	}

	public void sendSms(String phoneNumber, String message) {
		smsSender.sendSms(phoneNumber, message);
	}

}
