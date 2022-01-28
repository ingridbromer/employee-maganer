package br.com.ssys.user.api.model.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class UserNamePasswordDTO {
	
	private Object principal;
	
	private Object credentials;
	
	private Collection<? extends GrantedAuthority> authorities;
}
