package br.com.gptw.employeeMaganer.api.model.dto;

import br.com.gptw.employeeMaganer.api.model.Employee;
import lombok.Data;

@Data
public class ReportAgeDTO {
	
	Integer average;
	Employee younger;
	Employee older;

}
