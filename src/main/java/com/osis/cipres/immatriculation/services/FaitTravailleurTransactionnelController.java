package com.osis.cipres.immatriculation.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.osis.cipres.immatriculation.jsonForm.Tableau5;
import com.osis.cipres.immatriculation.jsonForm.Tableau8;
import com.osis.cipres.immatriculation.jsonForm.VgTravailleurActif;
import com.osis.cipres.immatriculation.jsonForm.VgTravailleurAutreMotifs;
import com.osis.cipres.immatriculation.jsonForm.VgTravailleurDecede;
import com.osis.cipres.immatriculation.jsonForm.VgTravailleurRetraite;
import com.osis.cipres.immatriculation.jsonForm.VueGlobalTotalTravailleur;
import com.osis.cipres.immatriculation.jsonForm.Tableau6_1;
import com.osis.cipres.immatriculation.jsonForm.Tableau6_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau6_NI;
import com.osis.cipres.immatriculation.jsonForm.Tableau7_1;
import com.osis.cipres.immatriculation.jsonForm.Tableau7_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau10;
import com.osis.cipres.immatriculation.repositories.FaitTravailleurTransactionnelRepository;
import com.osis.cipres.immatriculation.tables.Ima_fait_travailleur_transactionnel;
@CrossOrigin("*")
@RestController
public class FaitTravailleurTransactionnelController { 
	
	
	//**************************************************  REQUETE VUE GLOBALE  ******************************************//
////////////////////////////////////// Nouvelles immatriculations
	//nouvelle immatriculation
		@GetMapping("/newImaTrv/{no_annee}")
		public List<Tableau6_NI> vueGlobalTravailleurNI(@PathVariable int no_annee) {
		return faitTravailleurTransactionnelRepository.vueGlobalTravailleurNI(no_annee);
		}
		
		//nouvelle immatriculation/Intervalle de temps
		@GetMapping("/newImaTrvInterv/{datedebut}/{datefin}")
		public List<Tableau6_NI> vueGlobalTravailleurIntervNI(@PathVariable Date datedebut, @PathVariable Date datefin) {
		return faitTravailleurTransactionnelRepository.vueGlobalTravailleurIntervNI(datedebut, datefin);
		}
		
		
		//nouvelle immatriculation /  date complète
		@GetMapping("/newImDateTrv/{date_complete}")
		public List<Tableau6_NI> vueGlobalTravailleurDateNI(@PathVariable Date date_complete) {
		return faitTravailleurTransactionnelRepository.vueGlobalTravailleurDateNI(date_complete);
		}
	
		
//////////////////////////////////////Travailleur Actifs
		//travailleurs actifs
		@GetMapping("/TrvActif/{no_annee}")
		public List<VgTravailleurActif> VueGlobalTravailleurActif(@PathVariable int no_annee) {
		return faitTravailleurTransactionnelRepository.VueGlobalTravailleurActif(no_annee);
		}
		
		//travailleurs actifs/Intervalle de temps
		@GetMapping("/TrvActifInterv/{datedebut}/{datefin}")
		public List<VgTravailleurActif> VueGlobalTravailleurActifInterv(@PathVariable Date datedebut, @PathVariable Date datefin) {
		return faitTravailleurTransactionnelRepository.VueGlobalTravailleurActifInterv(datedebut, datefin);
		}
		
		
		//travailleurs actifs /  date complète
		@GetMapping("/TrvActifDate/{date_complete}")
		public List<VgTravailleurActif> VueGlobalTravailleurActifDate(@PathVariable Date date_complete) {
		return faitTravailleurTransactionnelRepository.VueGlobalTravailleurActifDate(date_complete);
		}


		
	
//////////////////////////////////////Retraités
		//travailleurs retraités
		@GetMapping("/TrvRetraite/{no_annee}")
		public List<VgTravailleurRetraite> TravailleurRetraite(@PathVariable int no_annee) {
		return faitTravailleurTransactionnelRepository.VueGlobalTravailleurRetraite(no_annee);
		}
		
		//travailleurs retraités/Intervalle de temps
		@GetMapping("/TrvRetraiteInterv/{datedebut}/{datefin}")
		public List<VgTravailleurRetraite> TravailleurRetraiteInterv(@PathVariable Date datedebut, @PathVariable Date datefin) {
		return faitTravailleurTransactionnelRepository.VueGlobalTravailleurRetraiteInterv(datedebut, datefin);
		}
		
		
		//travailleurs retraités/date complète
		@GetMapping("/TrvRetraiteDate/{date_complete}")
		public List<VgTravailleurRetraite> TravailleurRetraiteDate(@PathVariable Date date_complete) {
		return faitTravailleurTransactionnelRepository.VueGlobalTravailleurRetraiteDate(date_complete);
		}
		

//////////////////////////////////////Décedés
		//travailleurs décedés
		@GetMapping("/TrvDecede/{no_annee}")
		public List<VgTravailleurDecede> VueGlobalTravailleurDecede(@PathVariable int no_annee) {
		return faitTravailleurTransactionnelRepository.VueGlobalTravailleurDecede(no_annee);
		}
		
		//travailleurs décedés/Intervalle de temps
		@GetMapping("/TrvDecedeInterv/{datedebut}/{datefin}")
		public List<VgTravailleurDecede> VueGlobalTravailleurDecedeInterv(@PathVariable Date datedebut, @PathVariable Date datefin) {
		return faitTravailleurTransactionnelRepository.VueGlobalTravailleurDecedeInterv(datedebut, datefin);
		}
		
		
		//travailleurs décedés/date complète
		@GetMapping("/TrvDecedeDate/{date_complete}")
		public List<VgTravailleurDecede> VueGlobalTravailleurDecedeDate(@PathVariable Date date_complete) {
		return faitTravailleurTransactionnelRepository.VueGlobalTravailleurDecedeDate(date_complete);
		}


//////////////////////////////////////Autres motifs
		//travailleurs Autres motifs
		@GetMapping("/TrvAutreMotif/{no_annee}")
		public List<VgTravailleurAutreMotifs> VueGlobalTravailleurAutreMotif(@PathVariable int no_annee) {
		return faitTravailleurTransactionnelRepository.VueGlobalTravailleurAutreMotif(no_annee);
		}
		
		//travailleurs Autres motifs/Intervalle de temps
		@GetMapping("/TrvAutreMotifInterv/{datedebut}/{datefin}")
		public List<VgTravailleurAutreMotifs> VueGlobalTravailleurAutreMotifInterv(@PathVariable Date datedebut, @PathVariable Date datefin) {
		return faitTravailleurTransactionnelRepository.VueGlobalTravailleurAutreMotifInterv(datedebut, datefin);
		}
		
		
		//travailleurs Autres motifs/date complète
		@GetMapping("/TrvAutreMotifDate/{date_complete}")
		public List<VgTravailleurAutreMotifs> VueGlobalTravailleurAutreMotifDate(@PathVariable Date date_complete) {
		return faitTravailleurTransactionnelRepository.VueGlobalTravailleurAutreMotifDate(date_complete);
		}
		


//////////////////////////////////////Nombre Total Travailleurs
		//Nombre Total Travailleurs
		@GetMapping("/nombreTotalTrv/{no_annee}")
		public List<VueGlobalTotalTravailleur> VueGlobalTotalTravailleur(@PathVariable int no_annee) {
		return faitTravailleurTransactionnelRepository.VueGlobalTotalTravailleur(no_annee);
		}
		
		//Nombre Total Travailleurs/Intervalle de temps
		@GetMapping("/nombreTotalTrvInterv/{datedebut}/{datefin}")
		public List<VueGlobalTotalTravailleur> VueGlobalTotalTravailleurInterv(@PathVariable Date datedebut, @PathVariable Date datefin) {
		return faitTravailleurTransactionnelRepository.VueGlobalTotalTravailleurInterv(datedebut, datefin);
		}
		
		
		//Nombre Total Travailleurs/date complète
		@GetMapping("/nombreTotalTrvDate/{date_complete}")
		public List<VueGlobalTotalTravailleur> VueGlobalTotalTravailleurDate(@PathVariable Date date_complete) {
		return faitTravailleurTransactionnelRepository.VueGlobalTotalTravailleurDate(date_complete);
		}

	@Autowired
	FaitTravailleurTransactionnelRepository faitTravailleurTransactionnelRepository;

	@GetMapping("/FaitTravailleurList")
	public Page<Ima_fait_travailleur_transactionnel> getFaitTravailleur(){
		return faitTravailleurTransactionnelRepository.findAll(PageRequest.of(0, 100));
	} 
	
	
	//************************************************  TABLEAU 5   ******************************************//
	@GetMapping("/dataTableau5/{no_annee}")
	public List<Tableau5> getdataTableau5(@PathVariable int no_annee) {
		return faitTravailleurTransactionnelRepository.Tableau5(no_annee);
	}
	
	//************************************************  TABLEAU 6   ******************************************//
	
	//Requête tableau6
	@GetMapping("/dataTableau6DebutFin/{periode}")
	public List<Tableau6_1> Tableau6effectifDFp(@PathVariable Date periode) {
		return faitTravailleurTransactionnelRepository.Tableau6effectifDFp(periode);
	}
	
	@GetMapping("/dataTableau6NouvelleImma/{no_annee}")
	public List<Tableau6_2> Tableau6NouvelleImma(@PathVariable int no_annee) {
		return faitTravailleurTransactionnelRepository.Tableau6MotifNouvelleImma(no_annee);
	}
	
	@GetMapping("/dataTableau6Motif/{no_annee}")
	public List<Tableau6_2> Tableau6Motif(@PathVariable int no_annee) {
		return faitTravailleurTransactionnelRepository.Tableau6Motif(no_annee);
	}
	
	//************************************************  TABLEAU 7   ******************************************//
	
	//Requête tableau7
	@GetMapping("/dataTableau7DebutFin/{periode}")
	public List<Tableau7_1> Tableau3part1(@PathVariable Date periode) {
		return faitTravailleurTransactionnelRepository.Tableau7effectifDFp(periode);
	}
	
	@GetMapping("/dataTableau7NouvelleImma/{no_annee}")
	public List<Tableau7_2> Tableau7MotifNouvelleImma(@PathVariable int no_annee) {
		return faitTravailleurTransactionnelRepository.Tableau7MotifNouvelleImma(no_annee);
	}
	
	@GetMapping("/dataTableau7Motif/{no_annee}")
	public List<Tableau7_2> Tableau3part2(@PathVariable int no_annee) {
		return faitTravailleurTransactionnelRepository.Tableau7Motif(no_annee);
	}
	
	//************************************************  TABLEAU 8   ******************************************//
	
	//Requête tableau8
	@GetMapping("/dataTableau8/{no_annee}")
	public List<Tableau8> Tableau8(@PathVariable int no_annee) {
		return faitTravailleurTransactionnelRepository.Tableau8Data(no_annee);
	}
	
	//************************************************  TABLEAU 10   ******************************************//
			//Requête tableau10
			@GetMapping("/dataTableau10/{no_annee}")
			public ArrayList<Tableau10>[] Tableau10(@PathVariable int no_annee) {
				int annee=0;
				int n= 5;
				ArrayList<Tableau10>[] data = new ArrayList[n];
				for( int i=0;i<n; i++) {
					annee = no_annee - i;
				 data[i] =  (ArrayList<Tableau10>) faitTravailleurTransactionnelRepository.Tableau10Data(annee);				
				}
				return data ;
			}
			

			
}
