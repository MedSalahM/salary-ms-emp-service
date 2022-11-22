package com.mms.empsfp.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity(name="employee")
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String name;
	
	@OneToOne
	@JoinColumn(name="cat_id" , referencedColumnName = "id")
	private Categorie categorie;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="emp_id" , referencedColumnName = "id")
	private List<Experience> experiences;
}
