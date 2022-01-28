package br.com.ssys.employeeMaganer.api.model.dto;

import java.util.List;

import br.com.ssys.employeeMaganer.api.model.Employee;
import lombok.Data;

@Data
public class ReportAgeDTO {
	
	Long average;
	Employee younger;
	Employee older;

}
