package com.mms.empsfp.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExperienceDto {
	
	
	private Long id;
	private LocalDate grantedAt; 
	private int level;
	private boolean isRevoked;


}
