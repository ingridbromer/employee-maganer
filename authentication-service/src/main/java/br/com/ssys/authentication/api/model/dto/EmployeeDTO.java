package br.com.ssys.authentication.api.model.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class EmployeeDTO {

	UUID id;
	String email;
	String password;
	String name;
	List<String> namePermission;
	String token;

}