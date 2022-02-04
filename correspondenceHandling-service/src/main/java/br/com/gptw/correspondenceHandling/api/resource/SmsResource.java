package br.com.gptw.correspondenceHandling.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gptw.correspondenceHandling.api.service.SmsService;

@RestController
@RequestMapping("/sms")
public class SmsResource {

    private final SmsService service;

    @Autowired
    public SmsResource(SmsService service) {
        this.service = service;
    }

    @PostMapping("/{phoneNumber}")
    public void sendSms(@PathVariable String phoneNumber, String message) {
        service.sendSms(phoneNumber, message);
    }
}