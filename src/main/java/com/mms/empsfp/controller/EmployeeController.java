package com.mms.empsfp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mms.empsfp.dto.EmployeeDto;
import com.mms.empsfp.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/employee/")
public class EmployeeController {

	
	private final EmployeeService employeeService;
	
	@GetMapping("latest")
	public ResponseEntity<List<EmployeeDto>> latest(){
		

		var latest = employeeService.latest();
		
		ResponseEntity<List<EmployeeDto>> res = new ResponseEntity<List<EmployeeDto>>
		                  (latest,HttpStatus.OK);
	
		return res;
		
		
	}
	
	@PostMapping("addempl")
	public ResponseEntity<EmployeeDto> addNewFn(@RequestBody EmployeeDto dto){
		

		var created = employeeService.saveEmployee(dto);
		ResponseEntity<EmployeeDto> res = new ResponseEntity<EmployeeDto>
		                  (created,HttpStatus.CREATED);
	
		return res;
		
	}

	@PutMapping("editempl")
	public ResponseEntity<EmployeeDto> saveEditedEmp(@RequestBody EmployeeDto dto){
		

		var created = employeeService.editEmployee(dto);
		ResponseEntity<EmployeeDto> res = new ResponseEntity<EmployeeDto>
		                  (created,HttpStatus.ACCEPTED);
	
		return res;
		
	}

	
	@GetMapping("{id}")
	public ResponseEntity<?> fetchJcn(@PathVariable Long id){
		
		
		return ResponseEntity
				   .ok(employeeService.findEmployee(id));
		
	}
	
	@DeleteMapping("deleteall")
	public ResponseEntity<?> deleteAll(){
		
		employeeService.deleteAll();
		
		return ResponseEntity
				   .ok("deleted");
		
	}
	
	
	
}
