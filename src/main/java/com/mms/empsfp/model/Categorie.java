package com.mms.empsfp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mms.empsfp.dto.GroupeDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "categorie")
@Table(name = "categorie")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Categorie {

	@Id
	private Long id;
	private Integer pi;
	
	@OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn(name = "groupe_id" , referencedColumnName = "name")
	private Groupe groupe;
	
	 
}
