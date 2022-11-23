package com.mms.empsfp.service;

import java.util.List;
import java.util.Set;

import com.mms.empsfp.dto.EmployeeDto;
import com.mms.empsfp.dto.ExperienceDto;
import com.mms.empsfp.dto.TextResponse;

public interface EPService {

	
	List<ExperienceDto> save(ExperienceDto ep ,Long id);
	ExperienceDto latestExperienceRendred(Long id);
    List<TextResponse> possibleNextEchelon(Long id);
	
	
	
}
