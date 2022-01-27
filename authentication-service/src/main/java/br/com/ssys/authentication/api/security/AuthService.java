package br.com.ssys.authentication.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ssys.authentication.api.model.dto.EmployeeDTO;
import br.com.ssys.authentication.api.restEmployee.RestEmployee;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	RestEmployee restEmployee;
	
	@Autowired
	JWTUtil jwtUtil;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		EmployeeDTO employee = restEmployee.verifyEmployee(email);
		if (employee.getEmail() == null) {
			System.out.println("Funcionário não encontrado");
		}
		return new UserSS(employee.getId(), employee.getEmail(), employee.getName(), employee.getPassword(),
				employee.getNamePermission());
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
