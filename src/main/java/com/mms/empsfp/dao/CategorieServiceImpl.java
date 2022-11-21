package com.mms.empsfp.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mms.empsfp.dto.CategorieDto;
import com.mms.empsfp.dto.GroupeDto;
import com.mms.empsfp.dto.LocalDtoMapper;
import com.mms.empsfp.model.Categorie;
import com.mms.empsfp.model.Groupe;
import com.mms.empsfp.repo.CategorieRepo;
import com.mms.empsfp.service.CategorieService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategorieServiceImpl implements CategorieService{

	
	private final CategorieRepo catRepo;
	private final LocalDtoMapper localDtoMapper;

	
	
	@Override
	public List<CategorieDto> findByGroupeDto(String gg) {
		
		GroupeDto g = GroupeDto.builder().name(gg).build();
		
		Groupe gr = localDtoMapper.toGroupeModel(g);
		var founded = catRepo.findByGroupe(gr);
		
		var toSend=founded.stream().map(f->localDtoMapper.toCategorieDto(f))
		       .collect(Collectors.toList());
		       
		
		
		return toSend;
	}



	@Override
	public CategorieDto findById(Long id) {
	
		var founded=catRepo.findById(id)
		       .orElseThrow(()->new RuntimeException("cat not found"));
		
		var toSend = localDtoMapper.toCategorieDto(founded);
		
		
		return toSend;
	}
	
}
