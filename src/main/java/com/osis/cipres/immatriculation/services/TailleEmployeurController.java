package com.osis.cipres.immatriculation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osis.cipres.immatriculation.repositories.TailleEmployeurRepository;
import com.osis.cipres.immatriculation.tables.Ima_dim_taille_employeur;

@RestController
@CrossOrigin("*")
public class TailleEmployeurController {

	@Autowired
	private TailleEmployeurRepository tailleEmployeurRepository;
	
	@GetMapping("/tailleEmployeurList")
	public List<Ima_dim_taille_employeur> gettailleEmployeur(){
		return tailleEmployeurRepository.findAll();
	}
}
