package br.com.ssys.employeeMaganer.api.model.dto;

import br.com.ssys.employeeMaganer.api.model.Employee;
import lombok.Data;

@Data
public class ReportSalaryDTO {

	Long average;
	Employee lowest;
	Employee highest;
}
