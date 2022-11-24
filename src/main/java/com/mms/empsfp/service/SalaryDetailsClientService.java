package com.mms.empsfp.service;

import com.mms.empsfp.dto.EmployeeSalaryDetailsDto;

public interface SalaryDetailsClientService {

	final static String PAIEMENT_API="http://localhost:8081/api/sd/new";

    public EmployeeSalaryDetailsDto  createNewSD(Long id);
    
         
		
}
