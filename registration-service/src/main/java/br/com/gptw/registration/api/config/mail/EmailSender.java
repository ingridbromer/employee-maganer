package br.com.gptw.registration.api.config.mail;

public interface EmailSender {
	void send(String to, String email);
}
