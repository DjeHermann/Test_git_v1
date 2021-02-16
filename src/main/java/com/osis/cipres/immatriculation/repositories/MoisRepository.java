package com.osis.cipres.immatriculation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osis.cipres.immatriculation.tables.Ima_dim_mois;

public interface MoisRepository extends JpaRepository<Ima_dim_mois, Long> {

}
