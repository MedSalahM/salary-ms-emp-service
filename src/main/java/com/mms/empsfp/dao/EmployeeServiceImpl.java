package com.mms.empsfp.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.mms.empsfp.dto.EmployeeDto;
import com.mms.empsfp.dto.LocalDtoMapper;
import com.mms.empsfp.repo.EmployeeRepository;
import com.mms.empsfp.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository employeeRepo;
	private final LocalDtoMapper localDtoMapper;
	@Override
	public EmployeeDto saveEmployee(EmployeeDto dto) {
		
		
		var toSave = localDtoMapper.toEmployeeModel(dto);
		var saved=employeeRepo.save(toSave);
		var toSend=localDtoMapper.toEmployeeDto(saved);
	    
		
		
		return toSend;
	}
	@Override
	public EmployeeDto findEmployee(Long id) {
		
	
		var saved=employeeRepo.findById(id)
				               .orElseThrow(()->new RuntimeException( "emp not found "+id));
		var toSend=localDtoMapper.toEmployeeDto(saved);
		
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
	public void deleteAllNdms() {
	
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
