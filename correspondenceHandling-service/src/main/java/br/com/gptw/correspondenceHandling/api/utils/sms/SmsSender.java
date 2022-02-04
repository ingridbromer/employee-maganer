package br.com.gptw.correspondenceHandling.api.utils.sms;

public interface SmsSender {
	
	void sendSms (String phoneNumber, String message);

}
