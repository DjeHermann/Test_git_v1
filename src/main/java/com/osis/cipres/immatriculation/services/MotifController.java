package com.osis.cipres.immatriculation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osis.cipres.immatriculation.repositories.MotifRepository;
import com.osis.cipres.immatriculation.tables.Ima_dim_motif;

@RestController
@CrossOrigin("*")
public class MotifController {
	@Autowired
	private MotifRepository motifReposotory;
	
	@GetMapping("/motifList")
	public List<Ima_dim_motif> getMotifList(){
		return motifReposotory.findAll();	
	}
	
	

}
