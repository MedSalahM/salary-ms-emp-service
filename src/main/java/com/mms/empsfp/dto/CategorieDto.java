package com.mms.empsfp.dto;

import java.util.Set;

import com.mms.empsfp.model.Categorie;
import com.mms.empsfp.model.Groupe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategorieDto {

	
	private Long id;
	private Integer pi;
	private Groupe groupe;
	
}
