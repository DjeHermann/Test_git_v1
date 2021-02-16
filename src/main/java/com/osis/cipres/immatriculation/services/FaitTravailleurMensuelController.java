package com.osis.cipres.immatriculation.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.osis.cipres.immatriculation.jsonForm.Tableau5;
import com.osis.cipres.immatriculation.jsonForm.Tableau6_1;
import com.osis.cipres.immatriculation.jsonForm.Tableau6_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau6_3;
import com.osis.cipres.immatriculation.jsonForm.Tableau7_1;
import com.osis.cipres.immatriculation.jsonForm.Tableau7_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau7_3;
import com.osis.cipres.immatriculation.repositories.FaitTravailleurMensuelRepository;
import com.osis.cipres.immatriculation.repositories.FaitTravailleurTransactionnelRepository;



public class FaitTravailleurMensuelController {
	
	@Autowired
	private FaitTravailleurMensuelRepository faitTravailleurMensuelRepository;
	
	@Autowired
	private FaitTravailleurTransactionnelRepository  faitTravailleurTransactionnelRepository;
	
	
	
	//************************************************  TABLEAU 5   ******************************************//
	
	//Requête tableau5
//	@GetMapping("/dataTableau5/{no_annee}")
//	public List<Tableau5> getdataTableau5(@PathVariable int no_annee) {
//		return faitTravailleurMensuelRepository.Tableau5(no_annee);
//	}
	
	//Fin Requête tableau5
	
	//************************************************  TABLEAU 6   ******************************************//
	
		//Requête tableau6
//		@GetMapping("/dataTableau6/part1/{periode}")
//		public List<Tableau6_1> Tableau6part1(@PathVariable Date periode) {
//			return faitTravailleurMensuelRepository.Tableau6effectifDp(periode);
//		}
//		@GetMapping("/dataTableau6/part2/{no_annee}")
//		public List<Tableau6_2> Tableau6part2(@PathVariable int no_annee) {
//			return faitTravailleurMensuelRepository.Tableau6Motif(no_annee);
//		}
//		
//		@GetMapping("/dataTableau6/part3/{periode}")
//		public List<Tableau6_3> Tableau6part3(@PathVariable Date periode) {
//			return faitTravailleurMensuelRepository.Tableau6effectifFp(periode);
//
//		}
		
		//Fin Requête tableau6
		
		
		
		//************************************************  TABLEAU 7   ******************************************//
		
		//Requête tableau7
//			@GetMapping("/dataTableau7/part1/{periode}")
//			public List<Tableau7_1> Tableau7part1(@PathVariable Date periode) {
//				return faitTravailleurMensuelRepository.Tableau7effectifDp(periode);
//			}
//			@GetMapping("/dataTableau7/part2/{no_annee}")
//			public List<Tableau7_2> Tableau7part2(@PathVariable int no_annee) {
//				return faitTravailleurMensuelRepository.Tableau7Motif(no_annee);
//			}
//			
//			@GetMapping("/dataTableau7/part3/{periode}")
//			public List<Tableau7_3> Tableau7part3(@PathVariable Date periode) {
//				return faitTravailleurMensuelRepository.Tableau7effectifFp(periode);
//			}
}
