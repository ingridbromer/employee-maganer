package br.com.gptw.registration.api.utils.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class SmsService {

	private final SmsSender smsSender;

	@Autowired
	public SmsService(@Qualifier("twilio") TwilioSmsSender smsSender) {
		this.smsSender = smsSender;
	}

	public String sendSms(SmsRequest smsRequest) {
		return smsSender.sendSms(smsRequest);
	}

}
