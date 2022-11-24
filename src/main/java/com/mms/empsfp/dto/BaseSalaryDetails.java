package com.mms.empsfp.dto;

import com.mms.empsfp.model.Groupe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BaseSalaryDetails {

	
	private int echelon;
	private String group;
	private long categorie; 
}
