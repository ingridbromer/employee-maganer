package br.com.gptw.registration.api.utils.mail;

public interface EmailSender {
	void send(String to, String email);
}
