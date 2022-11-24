package com.mms.empsfp.dao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.mms.empsfp.dto.BaseSalaryDetails;
import com.mms.empsfp.dto.CategorieDto;
import com.mms.empsfp.dto.EmployeeDto;
import com.mms.empsfp.dto.EmployeeSalaryDetailsDto;
import com.mms.empsfp.dto.ExperienceDto;
import com.mms.empsfp.dto.LocalDtoMapper;
import com.mms.empsfp.repo.EmployeeRepository;
import com.mms.empsfp.service.EPService;
import com.mms.empsfp.service.EmployeeService;
import com.mms.empsfp.service.SalaryDetailsClientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository employeeRepo;
	private final LocalDtoMapper localDtoMapper;
	private final SalaryDetailsClientService salaryDetailsClientService;

	

	@Override
	public EmployeeDto saveEmployee(EmployeeDto dto) {
		
		
		var toSave = localDtoMapper.toEmployeeModel(dto);
		var saved=employeeRepo.save(toSave);
		var toSend=localDtoMapper.toEmployeeDto(saved);
	    
		salaryDetailsClientService.createNewSD(toSend.getId());
		
		
		
		return toSend;
	}
	@Override
	public EmployeeDto findEmployee(Long id) {
		
	
		var saved=employeeRepo.findById(id)
				               .orElseThrow(()->new RuntimeException( "emp not found "+id));
		var toSend=localDtoMapper.toEmployeeDto(saved);
		
	    var eps=toSend.getExperiences();

		
        if(eps.size()>0) {
        	 
        	 
        	 Comparator<ExperienceDto> c = (a,b)->{
        		 
        		 if(a.getGrantedAt().isBefore(b.getGrantedAt())) return 1;
        		 
        		 return -1;
        	 };
        	 
        	 var sorted=eps.stream()
        	 .sorted(c)
        	 .collect(Collectors.toList());
        	 
        	
        	toSend.setExperiences(sorted);
        	 
        	  
         }
		
		
		return toSend;
	}
	@Override
	public List<EmployeeDto> latest() {
	
		var founded  =employeeRepo.latest();
		
		List<EmployeeDto> toSend = founded.stream().map(
				  
				  emp->localDtoMapper.toEmployeeDto(emp)
				  
				).collect(Collectors.toList());
		
		return toSend;
	}
	@Override
	public List<EmployeeDto> containsName(String name) {
	
		
		
		return null;
	}
	@Override
	public void deleteAll() {
	
		employeeRepo.deleteAll();
		
		
	}
	@Override
	public EmployeeDto editEmployee(EmployeeDto dto) {
		
		
		var toSave = localDtoMapper.toEmployeeModel(dto);
		var saved=employeeRepo.save(toSave);
		var toSend=localDtoMapper.toEmployeeDto(saved);
	    
		
		
		
		
		
		return toSend;
	}
	
	
}
	

