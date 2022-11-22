package com.mms.empsfp.service;

import java.util.List;

import com.mms.empsfp.dto.EmployeeDto;

public interface EmployeeService {

	
	EmployeeDto saveEmployee(EmployeeDto dto);
	EmployeeDto editEmployee(EmployeeDto dto);
	EmployeeDto findEmployee(Long id);
    List<EmployeeDto> latest();	
	List<EmployeeDto> containsName(String name);	
    void deleteAll();
  

    
}
