package com.mms.empsfp.dao;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.mms.empsfp.dto.EmployeeSalaryDetailsDto;
import com.mms.empsfp.service.SalaryDetailsClientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SDClientImpl implements SalaryDetailsClientService {
	
	private final  RestTemplate restTemplate ;

	@Override
	public EmployeeSalaryDetailsDto createNewSD(Long id) {
		 EmployeeSalaryDetailsDto foo;
		 try {
			 
		     var sd = new EmployeeSalaryDetailsDto(id); 
			 HttpEntity<EmployeeSalaryDetailsDto> request = new HttpEntity<>(sd);
			  foo = 
		     restTemplate.postForObject(PAIEMENT_API, request, EmployeeSalaryDetailsDto.class);
			 
			 
			 }
			 
			 catch(RestClientException e) {
				 
				 throw new RuntimeException("Error access au "+PAIEMENT_API);
			 }
		
		return foo;
	}


}
