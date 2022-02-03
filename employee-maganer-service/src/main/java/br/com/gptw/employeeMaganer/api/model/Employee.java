package br.com.gptw.employeeMaganer.api.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_EMPLOYEE")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	private String name;
	
	@Email(message = "Insert a valid e-mail")
	private String email;
	
	private String department;
	
	private Long salary;
	
	@Past(message="Date of birth must be in the past.")
	private LocalDate birthDate;
	

}
