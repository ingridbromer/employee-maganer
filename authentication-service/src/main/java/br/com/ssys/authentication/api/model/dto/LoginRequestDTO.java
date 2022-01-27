package br.com.ssys.authentication.api.model.dto;
import lombok.Data;

@Data
public class LoginRequestDTO {

	private String email;

	private String password;
}
