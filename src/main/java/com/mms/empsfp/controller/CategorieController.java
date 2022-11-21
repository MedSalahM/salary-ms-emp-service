package com.mms.empsfp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mms.empsfp.dto.CategorieDto;
import com.mms.empsfp.dto.EmployeeDto;
import com.mms.empsfp.dto.GroupeDto;
import com.mms.empsfp.model.Groupe;
import com.mms.empsfp.service.CategorieService;
import com.mms.empsfp.service.GroupeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/categorie/")
@RequiredArgsConstructor
public class CategorieController {

	private final GroupeService groupService;
	private final CategorieService categorieService;

	
	@GetMapping("group/{cat}")
	public ResponseEntity<List<CategorieDto>> listOfGroups(@PathVariable String cat){
		
		
		var groups = categorieService.findByGroupeDto(cat);
		
		ResponseEntity<List<CategorieDto>> res = new ResponseEntity<List<CategorieDto>>
		                  (groups,HttpStatus.OK);
	
		return res;
		
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CategorieDto> listOfGroups(@PathVariable Long id){
		
		
		var groups = categorieService.findById(id);
		
		ResponseEntity<CategorieDto> res = new ResponseEntity<CategorieDto>
		                  (groups,HttpStatus.OK);
	
		return res;
		
		
	}
	
	
	@GetMapping("group/all")
	public ResponseEntity<List<GroupeDto>> listOfGroups(){
		
		
		var groups = groupService.groupList();
		
		ResponseEntity<List<GroupeDto>> res = new ResponseEntity<List<GroupeDto>>
		                  (groups,HttpStatus.OK);
	
		return res;
		
		
	}
	
	
}
