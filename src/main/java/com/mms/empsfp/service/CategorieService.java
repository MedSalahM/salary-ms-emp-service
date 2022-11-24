package com.mms.empsfp.service;

import java.util.List;

import com.mms.empsfp.dto.CategorieDto;
import com.mms.empsfp.dto.GroupeDto;

public interface CategorieService {
	
	
	List<CategorieDto> findByGroupeDto(String g);
	CategorieDto findById(Long id);

	
}
