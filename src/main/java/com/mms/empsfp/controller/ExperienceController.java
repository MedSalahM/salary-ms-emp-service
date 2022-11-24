package com.mms.empsfp.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mms.empsfp.dto.CategorieDto;
import com.mms.empsfp.dto.EmployeeDto;
import com.mms.empsfp.dto.ExperienceDto;
import com.mms.empsfp.dto.TextResponse;
import com.mms.empsfp.service.EPService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/employee/ep/")
public class ExperienceController {

	private final EPService epService;
	
	@PostMapping("add/{emp}")
	public ResponseEntity<List<ExperienceDto>> addNewEp(@RequestBody ExperienceDto dto , @PathVariable Long emp){
		
		var created = epService.save(dto,emp);
		ResponseEntity<List<ExperienceDto>> res = new ResponseEntity<List<ExperienceDto>>
		                  (created,HttpStatus.CREATED);
	
		return res;
		
	}
	
	@GetMapping("latest/{id}")
	public ResponseEntity<ExperienceDto> latestEp(@PathVariable Long id){
		

		var latest = epService.latestExperienceRendred(id);
		
		ResponseEntity<ExperienceDto> res = new ResponseEntity<ExperienceDto>
		                  (latest,HttpStatus.OK);
	
		return res;
		
		
	}
	
	@GetMapping("next/{id}")
	public ResponseEntity<?> nextPossibleEp(@PathVariable Long id){
		

		var latest = epService.possibleNextEchelon(id);
		
		ResponseEntity<List<TextResponse>> res = new ResponseEntity<List<TextResponse>>
		                  (latest,HttpStatus.OK);
	
		return res;
		
		
	}
	

}
