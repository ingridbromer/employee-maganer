package br.com.gptw.correspondenceHandling.api.utils.sms;

import br.com.gptw.correspondenceHandling.api.model.SmsRequest;

public interface SmsSender {
	
	void sendSms (SmsRequest smsRequest);

}
