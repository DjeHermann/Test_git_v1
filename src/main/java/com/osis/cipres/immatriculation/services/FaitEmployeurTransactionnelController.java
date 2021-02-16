package com.osis.cipres.immatriculation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osis.cipres.immatriculation.repositories.FaitEmployeurTransactionnelRepository;

import com.osis.cipres.immatriculation.tables.Ima_fait_employeur_transactionnel;

@CrossOrigin("*")
@RestController
public class FaitEmployeurTransactionnelController {
	
	@Autowired 
	FaitEmployeurTransactionnelRepository faitEmployeurTransactionnelRepository ;
	@GetMapping("/FaitTranList")
	public List<Ima_fait_employeur_transactionnel> getEmployeurList(){
		return faitEmployeurTransactionnelRepository.getFaitList(PageRequest.of(0,484655));
	}
	

}
