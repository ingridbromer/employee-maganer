package br.com.gptw.registration.api.config.mail;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
//TODO: Regex to validate e-mail
//For now: every e-mail is valid    	
        return true;
    }
}