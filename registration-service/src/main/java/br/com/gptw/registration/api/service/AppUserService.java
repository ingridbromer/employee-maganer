package br.com.gptw.registration.api.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gptw.registration.api.exceptions.ResourceNotFoundException;
import br.com.gptw.registration.api.model.AppUser;
import br.com.gptw.registration.api.model.ConfirmationToken;
import br.com.gptw.registration.api.repository.AppUserRepository;
import br.com.gptw.registration.api.utils.Constants;
import lombok.AllArgsConstructor;

//To find the User when Login
@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

	private final AppUserRepository appUserRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ConfirmationTokenService confirmationTokenService;

	// Find the User by the e-mail
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return appUserRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException(Constants.EMAIL_NOT_FOUND + email));
	}

	public String signUpUser(AppUser appUser) {
		// Search User by Email
		boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();

		if (userExists) {
			throw new IllegalStateException("Já existe um usuário cadastrado com esse e-mail!");
		}
		// Encrypted Password Generation
		String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

		appUser.setPassword(encodedPassword);

		appUserRepository.save(appUser);

		// Generator token
		String token = UUID.randomUUID().toString();

		// Token expires in 15 minutes
		ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15), appUser);

		// Save token
		confirmationTokenService.saveConfirmationToken(confirmationToken);

		return token;

	}

	public int enableAppUser(String email) {
		return appUserRepository.enableAppUser(email);
	}
	
	public AppUser findByEmail(String email) {
		Optional<AppUser> user = appUserRepository.findByEmail(email);
		return user.orElseThrow(() -> new ResourceNotFoundException(Constants.EMAIL_NOT_FOUND + email));
	}

}
