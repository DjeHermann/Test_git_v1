package com.osis.cipres.immatriculation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osis.cipres.immatriculation.repositories.BrancheRepository;
import com.osis.cipres.immatriculation.tables.Ima_dim_branche_activite;


@RestController
@CrossOrigin("*")
public class BrancheController {
	
	@Autowired
	private BrancheRepository brancheRepository;
	
	@GetMapping("/brancheList")
	public List<Ima_dim_branche_activite> getbrancheList(){
		return brancheRepository.findAll();
	}
		
	
		
	

}
