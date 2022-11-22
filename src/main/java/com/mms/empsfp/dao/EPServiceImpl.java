package com.mms.empsfp.dao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.empsfp.dto.ExperienceDto;
import com.mms.empsfp.dto.LocalDtoMapper;
import com.mms.empsfp.dto.TextResponse;
import com.mms.empsfp.repo.EPRepository;
import com.mms.empsfp.service.EPService;
import com.mms.empsfp.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EPServiceImpl implements EPService{

	
	private final EPRepository epRepo;
	private final LocalDtoMapper localDtoMapper;
	
	@Autowired
	private EmployeeService empService;
	
	@Override
	public List<ExperienceDto> save(ExperienceDto ep, Long id) {
		

		var employeeDto = empService.findEmployee(id);
		 employeeDto.addExperience(ep);
		 
		 var savedEmp = empService.editEmployee(employeeDto);
		 
		   return savedEmp.getExperiences();
		
		
		
		
		
		
		
	}
	@Override
	public TextResponse latestExperienceRendred(Long id) {
		
		
	 
		String experience="No experience found";
		
		var dto = empService.findEmployee(id);
		
	    var eps=dto.getExperiences();
		
         if(eps.size()>0) {
        	 
        	 
        	 Comparator<ExperienceDto> c = (a,b)->{
        		 
        		 if(a.getGrantedAt().isBefore(b.getGrantedAt())) return 1;
        		 
        		 return -1;
        	 };
        	 
        	 var sorted=eps.stream().filter(e->e.isRevoked()==false)
        	 .sorted(c)
        	 .collect(Collectors.toList());
        	 
        	
        	if(sorted.size()>0) {
        		 experience=String.format("Employee possede Echelon %d obtenu le %s",
            			 sorted.get(0).getLevel(),
            			 sorted.get(0).getGrantedAt()
            			 );
        	}
        	 
        	  
         }
	    
		return TextResponse.builder()
				.textResponse(experience).build();
	}

}
