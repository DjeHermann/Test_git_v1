package com.osis.cipres.immatriculation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osis.cipres.immatriculation.tables.Ima_dim_motif;

public interface MotifRepository extends JpaRepository<Ima_dim_motif, Long> {

}
