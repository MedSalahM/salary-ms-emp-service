package com.mms.empsfp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeSalaryDetailsDto {

	private Long empId;
	private int echelon;
	private String groupe;
	private long categorie;
	public EmployeeSalaryDetailsDto(Long empId) {
		super();
		this.empId = empId;
	}

	
	
}
