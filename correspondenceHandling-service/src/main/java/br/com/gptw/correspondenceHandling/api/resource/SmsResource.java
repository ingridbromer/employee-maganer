package br.com.gptw.correspondenceHandling.api.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gptw.correspondenceHandling.api.model.SmsRequest;
import br.com.gptw.correspondenceHandling.api.service.SmsService;

@RestController
@RequestMapping("/sms")
public class SmsResource {

    private final SmsService service;

    @Autowired
    public SmsResource(SmsService service) {
        this.service = service;
    }

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        service.sendSms(smsRequest);
    }
}