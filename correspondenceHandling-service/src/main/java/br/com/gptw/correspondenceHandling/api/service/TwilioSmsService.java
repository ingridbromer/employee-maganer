package br.com.gptw.correspondenceHandling.api.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import br.com.gptw.correspondenceHandling.api.config.TwilioConfig;
import br.com.gptw.correspondenceHandling.api.utils.sms.SmsSender;

@Service("twilio")
public class TwilioSmsService implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsService.class);

    private final TwilioConfig twilioConfiguration;

    @Autowired
    public TwilioSmsService(TwilioConfig twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(String phoneNumber, String message) {
        if (isPhoneNumberValid(phoneNumber)) {
            PhoneNumber to = new PhoneNumber(phoneNumber);
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            //String message = smsRequest.getMessage();
            //TO SEND A TOKEN VIA SMS:
            String token = new String();
            token.concat("Token de acesso: " + UUID.randomUUID().toString());
            MessageCreator creator = Message.creator(to, from, token);
            creator.create();
            LOGGER.info("Envio de SMS: {}", token);
        } else {
            throw new IllegalArgumentException(
                    "Número de telefone [" + phoneNumber + "] não é válido!"
            );
        }
        //return message; 
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        // TODO: validacao de numero de telefone
        return true;
    }
}
