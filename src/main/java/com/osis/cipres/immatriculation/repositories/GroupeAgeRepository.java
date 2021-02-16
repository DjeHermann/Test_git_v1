package com.osis.cipres.immatriculation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.osis.cipres.immatriculation.tables.Ima_dim_groupe_age;

public interface GroupeAgeRepository extends JpaRepository<Ima_dim_groupe_age, Long>{
	
	@Query("Select c from Ima_dim_groupe_age c order by c.grp_code")
	public List<Ima_dim_groupe_age> findAllOrderByCle();

}
