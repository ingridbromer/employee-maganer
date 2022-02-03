package br.com.gptw.registration.api.mapper;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import br.com.gptw.registration.api.model.dto.UserNamePasswordDTO;

@Service
public class UserNamePasswordMapper {

	public UsernamePasswordAuthenticationToken toEntity(UserNamePasswordDTO dto) {
		if (dto != null) {
			return new UsernamePasswordAuthenticationToken(dto.getPrincipal(), dto.getCredentials(),
					dto.getAuthorities());
		}
		return null;
	}
}
