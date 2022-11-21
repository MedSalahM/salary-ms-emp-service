package com.mms.empsfp.dto;

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
	private Categorie categorie;

}
