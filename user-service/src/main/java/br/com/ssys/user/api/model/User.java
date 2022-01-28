package br.com.ssys.user.api.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_USUARIO")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	private UUID id;

	@Email
	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;

	@Size(min = 60, max = 60, message="Password must have 60 characters")
	@Column(name = "SENHA")
	private String password;

	@ManyToOne
	@JoinColumn(name = "CARGO_ID")
	private Role role;
}
