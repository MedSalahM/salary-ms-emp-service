package com.mms.empsfp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mms.empsfp.model.Categorie;
import com.mms.empsfp.model.Groupe;

public interface CategorieRepo extends JpaRepository<Categorie, Long>{

	List<Categorie> findByGroupe(Groupe groupe);
	
}
