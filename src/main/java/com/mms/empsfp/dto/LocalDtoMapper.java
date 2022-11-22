package com.mms.empsfp.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mms.empsfp.model.Categorie;
import com.mms.empsfp.model.Employee;
import com.mms.empsfp.model.Experience;
import com.mms.empsfp.model.Groupe;


@Component
public class LocalDtoMapper {

	
	private ModelMapper mapper;

	public LocalDtoMapper(ModelMapper mapper) {
		super();
		this.mapper = mapper;
	}

	
	
	
	
	public  Employee toEmployeeModel(EmployeeDto dto) {
		
		return mapper.map(dto, Employee.class);
	}
	
	public  EmployeeDto toEmployeeDto(Employee model) {
		
		return mapper.map(model, EmployeeDto.class);
	}
	
	
	public  Groupe toGroupeModel(GroupeDto dto) {
		
		return mapper.map(dto, Groupe.class);
	}
	
	public  GroupeDto toGroupeDto(Groupe model) {
		
		return mapper.map(model, GroupeDto.class);
	}
	
	
	
    public  Categorie toCategorieModel(CategorieDto dto) {
		
		return mapper.map(dto, Categorie.class);
	}
	
	public  CategorieDto toCategorieDto(Categorie model) {
		
		return mapper.map(model, CategorieDto.class);
	}
	
	
	   public  Experience toExperienceModel(ExperienceDto dto) {
			
			return mapper.map(dto, Experience.class);
		}
		
		public  ExperienceDto toExperienceDto(Experience model) {
			
			return mapper.map(model, ExperienceDto.class);
		}
		
	
}
