package br.com.gptw.registration.api.utils.sms;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import br.com.gptw.registration.api.config.TwilioConfig;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfig twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfig twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public String sendSms(SmsRequest smsRequest) {
    	String message = new String();
    	message.concat("Token de acesso: " + UUID.randomUUID().toString());
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Envio de SMS: {}", smsRequest);
        } else {
            throw new IllegalArgumentException(
                    "Número de telefone [" + smsRequest.getPhoneNumber() + "] não é válido!"
            );
        }
        return message;

    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        // TODO: validacao de numero de telefone
        return true;
    }
}
