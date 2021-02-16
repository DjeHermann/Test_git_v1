package com.osis.cipres.immatriculation.services;

import java.util.List;

import com.osis.cipres.immatriculation.tables.Ima_dim_pays;

public interface PaysService {
	public List<Ima_dim_pays> getPaysList();
	
}
