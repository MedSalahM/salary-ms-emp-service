package com.mms.empsfp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mms.empsfp.dto.GroupeDto;
import com.mms.empsfp.dto.LocalDtoMapper;
import com.mms.empsfp.model.Groupe;
import com.mms.empsfp.repo.GroupeRepo;
import com.mms.empsfp.service.GroupeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupeServiceImpl implements GroupeService{

	private final GroupeRepo groupRepo;
	private final LocalDtoMapper mapper;
	
	@Override
	public List<GroupeDto> groupList() {

		List<GroupeDto> groups =new ArrayList<>();
		
		
		
		
		groups = groupRepo.findAll().stream().map(e->mapper.toGroupeDto(e))
		         .collect(Collectors.toList());
		
		
		return groups; 
	}

}
