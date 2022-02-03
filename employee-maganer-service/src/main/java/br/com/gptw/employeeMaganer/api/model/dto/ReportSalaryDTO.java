package br.com.gptw.employeeMaganer.api.model.dto;

import br.com.gptw.employeeMaganer.api.model.Employee;
import lombok.Data;

@Data
public class ReportSalaryDTO {

	Long average;
	Employee lowest;
	Employee highest;
}
