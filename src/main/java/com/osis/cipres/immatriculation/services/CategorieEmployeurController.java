package com.osis.cipres.immatriculation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osis.cipres.immatriculation.repositories.CategorieEmployeurRepository;
import com.osis.cipres.immatriculation.tables.Ima_dim_categorie_employeur;

@RestController
@CrossOrigin("*")
public class CategorieEmployeurController {
	
	@Autowired
	CategorieEmployeurRepository categorieEmployeurRepository;

	@GetMapping("/categorieList")
	List<Ima_dim_categorie_employeur> categorieList(){
		return categorieEmployeurRepository.findAll();
	}

}
