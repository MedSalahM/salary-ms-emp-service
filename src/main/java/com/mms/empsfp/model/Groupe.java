package com.mms.empsfp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mms.empsfp.dto.GroupeDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "groupe")
@Table(name = "groupe")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Groupe {

	@Id
	private String name;
	private String type;
	
	

	
	
	
}
