package com.mms.empsfp.dto;

import java.util.List;
import java.util.Set;

import com.mms.empsfp.model.Categorie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class EmployeeDto {

	private Long id;
	private String name;
	private CategorieDto categorie;
	private List<ExperienceDto> experiences;
	
	
	public void addExperience(ExperienceDto dto) {
		
		this.experiences.add(dto);
		
	}

}
