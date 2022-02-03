package br.com.gptw.employeeMaganer.api.resource;

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

import br.com.gptw.employeeMaganer.api.model.Employee;
import br.com.gptw.employeeMaganer.api.model.dto.MessageDTO;
import br.com.gptw.employeeMaganer.api.model.dto.ReportAgeDTO;
import br.com.gptw.employeeMaganer.api.model.dto.ReportSalaryDTO;
import br.com.gptw.employeeMaganer.api.service.EmployeeService;
import br.com.gptw.employeeMaganer.api.utils.Constants;

@RestController
public class EmployeeResource {
	
	@Autowired
	EmployeeService service;

	
	@GetMapping("/employees/")
	public ResponseEntity<List<Employee>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/employees/{ID}")
	public ResponseEntity<Employee> findOne(@PathVariable UUID ID) {
		return ResponseEntity.ok().body(service.findOne(ID));
	}

	@PostMapping("/employees/")
	public ResponseEntity<MessageDTO> registerEmployee(@RequestBody @Valid Employee employee) {
		service.createEmployee(employee);
		return ResponseEntity.ok().body(new MessageDTO(Constants.EMPLOYEE_CREATED));
	}
	
	@PutMapping("/employees/{ID}")
	public ResponseEntity<MessageDTO> updateEmployee(@RequestBody @Valid Employee employee, @PathVariable UUID ID) throws RelationNotFoundException{
		service.updateEmployee(employee,ID);
		return ResponseEntity.ok().body(new MessageDTO(Constants.EMPLOYEE_UPDATED));
	}
	
	@DeleteMapping("/employees/{ID}") 
	public ResponseEntity<MessageDTO> deleteEmployee(@PathVariable UUID ID) {
		service.deleteEmployee(ID);
		return ResponseEntity.ok().body(new MessageDTO(Constants.EMPLOYEE_DEACTIVATED));
	}
	
	@GetMapping("/reports/employees/age/")
	public ResponseEntity<ReportAgeDTO> findByAge(){
		return ResponseEntity.ok().body(service.findEmployeesByAge());
	}
	@GetMapping("/reports/employees/salary/")
	public ResponseEntity<ReportSalaryDTO> findBySalary(){
		return ResponseEntity.ok().body(service.findEmployeesBySalary());
	}
}