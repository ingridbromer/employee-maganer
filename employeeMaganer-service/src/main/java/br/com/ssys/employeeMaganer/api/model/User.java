package br.com.ssys.employeeMaganer.api.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Email
	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;

	@Size(min = 60, max = 60, message="Password must have 60 characters")
	@Column(name = "SENHA")
	private String password;

}