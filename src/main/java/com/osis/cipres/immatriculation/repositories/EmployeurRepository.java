package com.osis.cipres.immatriculation.repositories;

//import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Pageable;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.osis.cipres.immatriculation.tables.Ima_dim_employeur;

public interface EmployeurRepository extends JpaRepository<Ima_dim_employeur, Long> {
	
	
	
	@Query("select c from Ima_dim_employeur c ")
	public List<Ima_dim_employeur> findCentFirst(Pageable pageable);
	
	//public List<Ima_dim_employeur> findFirst100();
}
