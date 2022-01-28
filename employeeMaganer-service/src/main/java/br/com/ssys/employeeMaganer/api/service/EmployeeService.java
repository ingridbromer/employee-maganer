package br.com.ssys.employeeMaganer.api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ssys.employeeMaganer.api.exceptions.ResourceNotFoundException;
import br.com.ssys.employeeMaganer.api.model.Employee;
import br.com.ssys.employeeMaganer.api.model.dto.ReportAgeDTO;
import br.com.ssys.employeeMaganer.api.model.dto.ReportSalaryDTO;
import br.com.ssys.employeeMaganer.api.repository.EmployeeRepository;
import br.com.ssys.employeeMaganer.api.utils.Constants;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	// Employee list
	public List<Employee> findAll() {
		return repository.findAll();
	}

	// Employee Detail
	public Employee findById(UUID id) {
		Optional<Employee> employee = repository.findById(id);
		return employee.orElseThrow(() -> new ResourceNotFoundException(Constants.EMPLOYEE_NOT_FOUND + id));
	}

	// Employee Detail with throws ResourceNotFoundException
	public Employee findOne(UUID id) {
		return findById(id);
	}

	// Employee Create
	public Employee createEmployee(Employee newEmployee) {
		Employee employee = new Employee();
		return repository.save(employee);

	}

	// Employee Update
	public Employee updateEmployee(Employee newEmployee, UUID id) throws RelationNotFoundException {
		try {
			Employee employee = repository.getOne(id);
			return repository.save(employee);
		} catch (Exception e) {
			throw new RelationNotFoundException();
		}
	}

	// Employee Delete
	public void deleteEmployee(UUID id) throws ResourceNotFoundException {
		Optional<Employee> present = repository.findById(id);
		if (present.isEmpty()) {
			throw new ResourceNotFoundException(Constants.EMPLOYEE_NOT_FOUND);
		}
		Employee employee = findById(id);
		repository.delete(employee);
	}

	public ReportAgeDTO findEmployeesByAge(){
	ReportAgeDTO listEmployessByAge = new ReportAgeDTO();
	List<Employee> listEmployees = repository.findAll();
	for(Employee employee: listEmployees) {
		listEmployessByAge.setYounger(listEmployees.get(0));
		listEmployessByAge.setOlder(listEmployees.get(listEmployees.size() - 1));
		listEmployessByAge.setAverage(listEmployees.get(0).getBirthDate().getTime() - listEmployees.get(listEmployees.size() - 1).getBirthDate().getTime());
	} 
	return listEmployessByAge;
	}
	
	public ReportSalaryDTO findEmployeesBySalary(){
	ReportSalaryDTO listEmployessBySalary = new ReportSalaryDTO();
	List<Employee> listEmployees = repository.findAll();
	for(Employee employee: listEmployees) {
		listEmployessBySalary.setLowest(listEmployees.get(0));
		listEmployessBySalary.setHighest(listEmployees.get(listEmployees.size() - 1));
		listEmployessBySalary.setAverage(listEmployees.get(0).getSalary() - listEmployees.get(listEmployees.size() - 1).getSalary());
	} 
	return listEmployessBySalary;
	}
}