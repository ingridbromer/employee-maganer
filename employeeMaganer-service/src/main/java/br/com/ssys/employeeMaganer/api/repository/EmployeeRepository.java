package br.com.ssys.employeeMaganer.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ssys.employeeMaganer.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID>{
	
	Optional<Employee> findById(UUID id);

}
