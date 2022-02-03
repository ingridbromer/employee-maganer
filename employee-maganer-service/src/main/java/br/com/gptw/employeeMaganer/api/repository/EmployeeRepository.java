package br.com.gptw.employeeMaganer.api.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gptw.employeeMaganer.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID>{
	
	Optional<Employee> findById(UUID id);


}
