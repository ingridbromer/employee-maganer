package br.com.ssys.authentication.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ssys.authentication.api.model.dto.UserDTO;
import br.com.ssys.authentication.api.restUser.RestUser;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	RestUser restClient;
	
	@Autowired
	JWTUtil jwtUtil;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDTO user = restClient.verifyClient(email);
		if(user.getEmail() == null) {
			System.out.println("Usuário não encontrado");
		}
		return new UserSS(user.getId(), user.getEmail(), user.getName(), user.getPassword(),
				user.getNamePermission());
	}
	
	public UsernamePasswordAuthenticationToken getAuthorization(String token) {
		if (jwtUtil.isValid(token)) {
			String username = jwtUtil.getUsername(token);
			UserDetails user = loadUserByUsername(username);
			return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		}
		return null;
	}
}
