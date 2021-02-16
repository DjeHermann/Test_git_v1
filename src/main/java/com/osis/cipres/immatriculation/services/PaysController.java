package com.osis.cipres.immatriculation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osis.cipres.immatriculation.tables.Ima_dim_pays;


@CrossOrigin("*")
@RestController
public class PaysController {
	@Autowired
	private PaysService paysService;
	
	@GetMapping("/paysList")
	public List<Ima_dim_pays> getPaysList() {
		return paysService.getPaysList();
	}
	
	

}
