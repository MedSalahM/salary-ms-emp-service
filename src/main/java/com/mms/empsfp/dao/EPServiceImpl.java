package com.mms.empsfp.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.empsfp.dto.BaseSalaryDetails;
import com.mms.empsfp.dto.CategorieDto;
import com.mms.empsfp.dto.EmployeeDto;
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
	public ExperienceDto latestExperienceRendred(Long id) {
		
		
	 
		 ExperienceDto lastest = null;
		
		var dto = empService.findEmployee(id);
		
	    var eps=dto.getExperiences();
		
         if(eps.size()>0) {
        	 
        	 
        	 Comparator<ExperienceDto> c = (a,b)->{
        		 
        		 if(a.getGrantedAt().equals(b.getGrantedAt())) {
        			 
        			 return b.getLevel()-a.getLevel();
        		 }
        		 
        		 if(a.getGrantedAt().isBefore(b.getGrantedAt())) return 1;
        			 
        			
        		 
        		 
        		 return -1;
        	 };
        	 
        
        	 var sorted=eps.stream().filter(e->e.isRevoked()==false)
        	 .sorted(c)
        	
        	 .collect(Collectors.toList());
        	 
        	
        	if(sorted.size()>0) {
        		
        		lastest=sorted.stream().findFirst().get();
        	}
        	 
        	  
         }
         
         
         
	    
		return lastest;
	}
	@Override
	public List<TextResponse> possibleNextEchelon(Long id) {
	
		
		ExperienceDto dto = latestExperienceRendred(id);
		
		List<TextResponse> possibleDates=new ArrayList<>();
		
		try {
			
		var r =	Objects.requireNonNull(dto);
		
		LocalDate date = r.getGrantedAt();
		
		var rapide=date.plusYears(2).plusMonths(6).toString();
		var slow=date.plusYears(3).toString();
		
		possibleDates.add(new TextResponse(rapide));
		possibleDates.add(new TextResponse(slow));

			
		}
		
		catch(NullPointerException e) {
			
			return possibleDates;
		}
		
		
		
		return possibleDates;
	}
	@Override
	public BaseSalaryDetails loadBSDetails(Long id) {
	
		EmployeeDto employee = empService.findEmployee(id);
		ExperienceDto latestExperience = latestExperienceRendred(id);
		
		
		CategorieDto cat = employee.getCategorie();

		int echelon=0;
		long categorie=0 ;
		String group=null;
		
		if(latestExperience!=null) {
			echelon = latestExperience.getLevel();
		}
		
		if(cat!=null) {
			
			group = cat.getGroupe().getName();
			categorie = cat.getId();
			
			
		}
		
		
		BaseSalaryDetails bsd = BaseSalaryDetails.builder()
				                 .categorie(categorie)
				                 .group(group)
				                 .echelon(echelon).build();
		
		return bsd;
	}

	
}
