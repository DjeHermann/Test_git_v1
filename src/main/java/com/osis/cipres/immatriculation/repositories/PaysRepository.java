package com.osis.cipres.immatriculation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.osis.cipres.immatriculation.tables.Ima_dim_pays;

public interface PaysRepository extends JpaRepository<Ima_dim_pays, Long>{
	
	@Query("Select c From Ima_dim_pays c Where c.pay_libelle=:pay_libelle")
	public Ima_dim_pays findByPay_libelle(String pay_libelle);
	
	
	@Query("Select c From Ima_dim_pays c Where c.id=:id")
	public Ima_dim_pays findOne(@Param("id")Long id);
}
