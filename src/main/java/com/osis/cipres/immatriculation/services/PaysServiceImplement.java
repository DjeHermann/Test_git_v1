package com.osis.cipres.immatriculation.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osis.cipres.immatriculation.repositories.PaysRepository;
import com.osis.cipres.immatriculation.tables.Ima_dim_pays;

@Service
@Transactional
public class PaysServiceImplement implements PaysService{
	
	@Autowired
	private PaysRepository paysRepository;

	@Override
	public List<Ima_dim_pays> getPaysList() {
		// TODO Auto-generated method stub
		return paysRepository.findAll();
	}

}
