package br.com.ssys.employeeMaganer.api.resource;

import java.util.List;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ssys.employeeMaganer.api.model.Employee;
import br.com.ssys.employeeMaganer.api.model.dto.MessageDTO;
import br.com.ssys.employeeMaganer.api.service.EmployeeService;
import br.com.ssys.employeeMaganer.api.utils.Constants;

@RestController
public class EmployeeResource {
	
	@Autowired
	EmployeeService service;

	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> findOne(@PathVariable UUID id) {
		return ResponseEntity.ok().body(service.findOne(id));
	}

	@PostMapping("/employee/register")
	public ResponseEntity<MessageDTO> registerEmployee(@RequestBody @Valid Employee employee) {
		service.createEmployee(employee);
		return ResponseEntity.ok().body(new MessageDTO(Constants.EMPLOYEE_CREATED));
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<MessageDTO> updateEmployee(@RequestBody @Valid Employee employee, @PathVariable UUID id) throws RelationNotFoundException{
		service.updateEmployee(employee,id);
		return ResponseEntity.ok().body(new MessageDTO(Constants.EMPLOYEE_UPDATED));
	}
	
	@DeleteMapping("/employee/{id}") 
	public ResponseEntity<MessageDTO> deleteEmployee(@PathVariable UUID id) {
		service.deleteEmployee(id);
		return ResponseEntity.ok().body(new MessageDTO(Constants.EMPLOYEE_DEACTIVATED));
	}
	
}