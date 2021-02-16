package com.osis.cipres.immatriculation.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osis.cipres.immatriculation.jsonForm.Tableau1;
import com.osis.cipres.immatriculation.jsonForm.Tableau1Details;
import com.osis.cipres.immatriculation.jsonForm.Tableau1_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau2Details_NI;
import com.osis.cipres.immatriculation.jsonForm.Tableau2Details_Radie;
import com.osis.cipres.immatriculation.jsonForm.Tableau2Details_Reactive;
import com.osis.cipres.immatriculation.jsonForm.Tableau2Details_Suspendus;
import com.osis.cipres.immatriculation.jsonForm.Tableau2_1;

import com.osis.cipres.immatriculation.jsonForm.Tableau2_1Details;
import com.osis.cipres.immatriculation.jsonForm.Tableau2_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau2_3;
import com.osis.cipres.immatriculation.jsonForm.Tableau2_NI;
import com.osis.cipres.immatriculation.jsonForm.Tableau3Details_NI;
import com.osis.cipres.immatriculation.jsonForm.Tableau3Details_Radie;
import com.osis.cipres.immatriculation.jsonForm.Tableau3Details_Reactive;
import com.osis.cipres.immatriculation.jsonForm.Tableau3Details_Suspendus;
import com.osis.cipres.immatriculation.jsonForm.Tableau3_1;
import com.osis.cipres.immatriculation.jsonForm.Tableau3_1Details;
import com.osis.cipres.immatriculation.jsonForm.Tableau3_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau3_3;
import com.osis.cipres.immatriculation.jsonForm.Tableau4;
import com.osis.cipres.immatriculation.jsonForm.Tableau4Details;
import com.osis.cipres.immatriculation.jsonForm.VgActif;
import com.osis.cipres.immatriculation.jsonForm.VgRadie;
import com.osis.cipres.immatriculation.jsonForm.VgReactive;
import com.osis.cipres.immatriculation.jsonForm.VgSuspendus;
import com.osis.cipres.immatriculation.repositories.FaitEmployeurMensuelRepository;
import com.osis.cipres.immatriculation.repositories.FaitEmployeurTransactionnelRepository;
import com.osis.cipres.immatriculation.tables.Ima_fait_employeur_mensuel;	
import com.osis.cipres.immatriculation.tables.Ima_fait_employeur_transactionnel;


@CrossOrigin("*")
@RestController
public class FaitEmployeurMensuelController {
	
	@Autowired
	private FaitEmployeurMensuelRepository faitEmployeurMensuelRepository;
	
	@Autowired
	private FaitEmployeurTransactionnelRepository  faitEmployeurTransactionnelRepository;
	
	@GetMapping("/faitMensEmpList")
	public List<Ima_fait_employeur_mensuel> getEmpList() {
		return faitEmployeurMensuelRepository.findAll();
	}
	
	//**************************************************  REQUETE VUE GLOBALE  ******************************************//
									//Nouvelle immatriculation
	//nouvelle immatriculation
	@GetMapping("/newI/{no_annee}")
	public List<Tableau2_NI> vueGlobalNI(@PathVariable int no_annee) {
		return faitEmployeurMensuelRepository.vueGlobalNI(no_annee);
	}
	
	//nouvelle immatriculation/Intervalle de temps
	@GetMapping("/newIma/{datedebut}/{datefin}")
	public List<Tableau2_NI> vueGlobalNInterv(@PathVariable Date datedebut, @PathVariable Date datefin) {
		return faitEmployeurMensuelRepository.vueGlobalNInterv(datedebut, datefin);
	}
	
	
	//nouvelle immatriculation /  date complète
		@GetMapping("/newImDate/{date_complete}")
		public List<Tableau2_NI> vueGlobalNIDate(@PathVariable Date date_complete) {
			return faitEmployeurMensuelRepository.vueGlobalNIDate(date_complete);
		}
		
								//actifs
	
	
	//employeurs actifs
	@GetMapping("/actif/{no_annee}")
	public List<VgActif> EmpActif(@PathVariable int no_annee) {
		return faitEmployeurMensuelRepository.EmpActif(no_annee);
	}
	
	//employeurs actifs/Intervalle de temps
	@GetMapping("/actifInterv/{datedebut}/{datefin}")
	public List<VgActif> EmpActif(@PathVariable Date datedebut, @PathVariable Date datefin) {
		return faitEmployeurMensuelRepository.EmpActifInterv(datedebut, datefin);
	}
	
	
	//employeurs actifs / date complète
	@GetMapping("/actifDate/{date_complete}")
	public List<VgActif> EmpActifDate(@PathVariable Date date_complete) {
		return faitEmployeurMensuelRepository.EmpActifDate(date_complete);
	}
	
	
								//reactives
		
	//employeurs reactive
	@GetMapping("/reactive/{no_annee}")
	public List<VgReactive> EmpReactive(@PathVariable int no_annee) {
		return faitEmployeurMensuelRepository.EmpReactive(no_annee);
	}
	
	//employeurs reactive/Intervalle de temps
	@GetMapping("/reactiveInterv/{datedebut}/{datefin}")
	public List<VgReactive> EmpReactive(@PathVariable Date datedebut, @PathVariable Date datefin) {
		return faitEmployeurMensuelRepository.EmpReactiveInterv(datedebut, datefin);
	}
	
	//employeurs reactive / date complete
	@GetMapping("/reactiveDate/{date_complete}")
	public List<VgReactive> EmpReactiveDate(@PathVariable Date date_complete) {
		return faitEmployeurMensuelRepository.EmpReactiveDate(date_complete);
	}
	
							//suspendus
	//employeurs suspendus
	@GetMapping("/suspendu/{no_annee}")
	public List<VgSuspendus> EmpSuspendus(@PathVariable int no_annee) {
		return faitEmployeurMensuelRepository.EmpSuspendus(no_annee);
	}
	
	//employeurs reactive/Intervalle de temps
	@GetMapping("/suspenduInterv/{datedebut}/{datefin}")
	public List<VgSuspendus> EmpSuspendus(@PathVariable Date datedebut, @PathVariable Date datefin) {
		return faitEmployeurMensuelRepository.EmpSuspendusInterv(datedebut, datefin);
	}
	
	@GetMapping("/suspenduDate/{date_complete}")
	public List<VgSuspendus> EmpSuspendusDate(@PathVariable Date date_complete) {
		return faitEmployeurMensuelRepository.EmpSuspendusDate(date_complete);
	}
	
							//radie
	
	//employeurs radie
	@GetMapping("/radie/{no_annee}")
	public List<VgRadie> EmpRadie(@PathVariable int no_annee) {
		return faitEmployeurMensuelRepository.EmpRadie(no_annee);
	}
	//employeurs radie/Intervalle de temps
	@GetMapping("/radieInterv/{datedebut}/{datefin}")
	public List<VgRadie> EmpRadie(@PathVariable Date datedebut, @PathVariable Date datefin) {
		return faitEmployeurMensuelRepository.EmpRadieInterv(datedebut, datefin);
	}
	
	//employeurs radie/ date complete
	@GetMapping("/radieDate/{date_complete}")
	public List<VgRadie> EmpRadieDate(@PathVariable Date date_complete) {
		return faitEmployeurMensuelRepository.EmpRadieDate(date_complete);
	}
	
							//Total employeurs
	
	//Nombre d'employeur/intervalle
	@GetMapping("/nbreEmployeurInterv/{datedebut}/{datefin}")
	public List<Tableau4> Tableau4AnneeInterv(@PathVariable Date datedebut, @PathVariable Date datefin){
		return faitEmployeurMensuelRepository.Tableau4AnneeInterv(datedebut, datefin);
	}
	
	//Nombre d'employeur/date complete
	@GetMapping("/nbreEmployeurDate/{date_complete}")
	public List<Tableau4> Tableau4AnneeDate(@PathVariable Date date_complete){
		return faitEmployeurMensuelRepository.TotalEmpDate(date_complete);
	}
	
	
	
	//************************************************  TABLEAU 1   ******************************************//
	
	//Requête tableau1
	@GetMapping("/dataTableau1/part1/{no_annee}")
	public List<Tableau1> getdataTableau1Part1(@PathVariable int no_annee) {
		return faitEmployeurMensuelRepository.Tableau1Part1(no_annee);
	}
	
	@GetMapping("/dataTableau1/part2/{no_annee}")
	public List<Tableau1_2> getdataTableau1Part2(@PathVariable int no_annee) {
		return faitEmployeurMensuelRepository.Tableau1Part2(no_annee);
	}
	
	//Requête tableau1 Details
	
	@GetMapping("/dataTableau1Detail/{no_annee}/{cat_libelle}/{no_mois}")
	public List<Tableau1Details> getdataTableau1Detail(@PathVariable int no_annee,@PathVariable String cat_libelle,@PathVariable int no_mois){
		return faitEmployeurTransactionnelRepository.Tableau1Details(no_annee, cat_libelle, no_mois);
	}
	
	//Fin Requête tableau1
	
	//************************************************  TABLEAU 2   ******************************************//
	
	//Requête tableau2
	
	
	@GetMapping("/dataTableau2/part1/{periode}")
	public List<Tableau2_1> Tableau2part1(@PathVariable Date periode) {
		return faitEmployeurMensuelRepository.Tableau2effectifDp(periode);
	}
	@GetMapping("/dataTableau2/part2/{no_annee}")
	public List<Tableau2_2> Tableau2part2(@PathVariable int no_annee) {
		return faitEmployeurMensuelRepository.Tableau2Motif(no_annee);
	}
	
	@GetMapping("/dataTableau2/part3/{periode}")
	public List<Tableau2_3> Tableau2part3(@PathVariable Date periode) {
		return faitEmployeurMensuelRepository.Tableau2effectifFp(periode);
	}
	
	//Requête tableau2 Debut et fin période Details
	
	@GetMapping("/dataTableau2/DebutFinPeriode/Detail/{no_annee}/{cat_libelle}")
	public List<Tableau2_1Details> getTableau2DetailsActifDebutPeriode(@PathVariable Date no_annee, @PathVariable String cat_libelle){
		return faitEmployeurTransactionnelRepository.Tableau2DetailsActifDebutPeriode(no_annee, cat_libelle);
	}
	
	 //Requêtes pour tableau 2 Details / Nouvelle immatriculation/
	
	@GetMapping("/dataTableau2/NI/Detail/{no_annee}/{cat_libelle}")
	public List<Tableau2Details_NI> getTableau2DetailsNI(@PathVariable int no_annee,@PathVariable String cat_libelle){
		return faitEmployeurTransactionnelRepository.Tableau2DetailsNI(no_annee,cat_libelle);
	}
	
	//Requêtes pour tableau 2 Details /employeur reactivé/
	@GetMapping("/dataTableau2/Reactive/Detail/{no_annee}/{cat_libelle}")
	public List<Tableau2Details_Reactive> getTableau2DetailsReactive(@PathVariable int no_annee,@PathVariable String cat_libelle){
		return faitEmployeurTransactionnelRepository.Tableau2DetailsReactive(no_annee,cat_libelle);
	}
	
	//Requêtes pour tableau 2 Details /employeur Suspendus/
	@GetMapping("/dataTableau2/Suspendu/Detail/{no_annee}/{cat_libelle}")
	public List<Tableau2Details_Suspendus> getTableau2DetailsSuspendus(@PathVariable int no_annee,@PathVariable String cat_libelle){
		return faitEmployeurTransactionnelRepository.Tableau2DetailsSuspendus(no_annee,cat_libelle);
	}
	
	//Requêtes pour tableau 2 Details /employeur Radie/
	@GetMapping("/dataTableau2/Radie/Detail/{no_annee}/{cat_libelle}")
	public List<Tableau2Details_Radie> getTableau2DetailsRadie(@PathVariable int no_annee,@PathVariable String cat_libelle){
		return faitEmployeurTransactionnelRepository.Tableau2DetailsRadie(no_annee,cat_libelle);
	}
	
	
	
	//Fin Requête tableau2
	
	
	//************************************************  TABLEAU 3   ******************************************//
	
	//Requête tableau3
		@GetMapping("/dataTableau3/part1/{periode}")
		public List<Tableau3_1> Tableau3part1(@PathVariable Date periode) {
			return faitEmployeurMensuelRepository.Tableau3effectifDp(periode);
		}
		@GetMapping("/dataTableau3/part2/{no_annee}")
		public List<Tableau3_2> Tableau3part2(@PathVariable int no_annee) {
			return faitEmployeurMensuelRepository.Tableau3Motif(no_annee);
		}
		
		@GetMapping("/dataTableau3/part3/{periode}")
		public List<Tableau3_3> Tableau3part3(@PathVariable Date periode) {
			return faitEmployeurMensuelRepository.Tableau3effectifFp(periode);
		}
		
		
		//Requête tableau3 Debut et fin période Details
		
		@GetMapping("/dataTableau3/DebutFinPeriode/Detail/{periode}/{seclibel}")
		public List<Tableau3_1Details> getTableau3DetailsActifDebutPeriode(@PathVariable Date periode, @PathVariable String seclibel){
			return faitEmployeurTransactionnelRepository.Tableau3DetailsActifDebutPeriode(periode, seclibel);
		}
		

		
		//Requête tableau3 Debut et fin période Details
//		
//		@GetMapping("/dataTableau3/DebutFinPeriode/Detail/{periode}/{seclibel}")
//		public List<Tableau3_1Details> getTableau3DetailsActifDebutPeriode(@PathVariable Date periode, @PathVariable String seclibel){
//			return faitEmployeurTransactionnelRepository.Tableau3DetailsActifDebutPeriode(periode, seclibel);
//		}
		
		 //Requêtes pour tableau 3 Details / Nouvelle immatriculation/

		@GetMapping("/dataTableau3/NI/Detail/{no_annee}/{seclibel}")
		public List<Tableau3Details_NI> getTableau3DetailsNI(@PathVariable int no_annee,@PathVariable String seclibel){
			return faitEmployeurTransactionnelRepository.Tableau3DetailsNI(no_annee,seclibel);
		}
		
		//Requêtes pour tableau 3 Details /employeur reactivé/
		@GetMapping("/dataTableau3/Reactive/Detail/{no_annee}/{seclibel}")
		public List<Tableau3Details_Reactive> getTableau3DetailsReactive(@PathVariable int no_annee,@PathVariable String seclibel){
			return faitEmployeurTransactionnelRepository.Tableau3DetailsReactive(no_annee,seclibel);
		}
		
		//Requêtes pour tableau 3 Details /employeur Suspendus/
		@GetMapping("/dataTableau3/Suspendu/Detail/{no_annee}/{seclibel}")
		public List<Tableau3Details_Suspendus> getTableau3DetailsSuspendus(@PathVariable int no_annee,@PathVariable String seclibel){
			return faitEmployeurTransactionnelRepository.Tableau3DetailsSuspendus(no_annee,seclibel);
		}
		
		//Requêtes pour tableau 3 Details /employeur Radie/
		@GetMapping("/dataTableau3/Radie/Detail/{no_annee}/{seclibel}")
		public List<Tableau3Details_Radie> getTableau3DetailsRadie(@PathVariable int no_annee,@PathVariable String seclibel){
			return faitEmployeurTransactionnelRepository.Tableau3DetailsRadie(no_annee,seclibel);
		}
		
		
		
		//Fin Requête tableau3
		
	//************************************************  TABLEAU 4   ******************************************//
		//Requête tableau4
		@GetMapping("/dataTableau4/{no_annee}")
		public ArrayList<Tableau4>[] Tableau4(@PathVariable int no_annee) {
			int annee=0;
			int n= 5;
			ArrayList<Tableau4>[] data = new ArrayList[n];
			for( int i=0;i<n; i++) {
				annee = no_annee - i;
			 data[i] =  (ArrayList<Tableau4>) faitEmployeurMensuelRepository.Tableau4(annee);				
			}
			return data ;
		}
		

		 //Requêtes pour tableau 4 Details
		
		@GetMapping("/dataTableau4/Detail/{no_annee}/{cat_libelle}")
		public List<Tableau4Details> getTableau4Details(@PathVariable int no_annee,@PathVariable String cat_libelle){
			return faitEmployeurTransactionnelRepository.Tableau4Details(no_annee,cat_libelle);
		}
		
		//Fin Requête tableau4
		
		
//*************************************************************REQUETE ANALYSE**************************************************************//
		
		//Paramètre Année
		@GetMapping("/FaitEmpbyAnnee")
		public ResponseEntity<Map<String,Object>> getAllemployeurByAnnee(
				 @RequestParam(defaultValue = "2019") int no_annee,
				 @RequestParam(defaultValue = "0") int page, 
				 @RequestParam(defaultValue = "10") int size){
			
			try {
		
			      Pageable paging = PageRequest.of(page, size);
			      
			      Page<Ima_fait_employeur_transactionnel> pageEmpbyAnnee;
		
			      pageEmpbyAnnee = faitEmployeurTransactionnelRepository.FaitEmpAn(no_annee, paging);
			        
			        Map<String, Object> response = new HashMap<>();
			        response.put("body", pageEmpbyAnnee.getContent());
			        response.put("currentPage", pageEmpbyAnnee.getNumber());
			        response.put("totalItems", pageEmpbyAnnee.getTotalElements());
			        response.put("totalPages", pageEmpbyAnnee.getTotalPages());

			        return new ResponseEntity<>(response, HttpStatus.OK);
			      } catch (Exception e) {
			        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      }
				}


		//Paramètre Taille entreprise
		@GetMapping("/FaitEmpbyTail")
		public ResponseEntity<Map<String,Object>> getAllemployeurByTail(
				 @RequestParam(defaultValue = "10") int tai_code,
				 @RequestParam(defaultValue = "0") int page, 
				 @RequestParam(defaultValue = "10") int size){
			
			try {
		
			      Pageable paging = PageRequest.of(page, size);
			      
			      Page<Ima_fait_employeur_transactionnel> pageEmpbyTail;
		
			      pageEmpbyTail = faitEmployeurTransactionnelRepository.FaitEmpTail(tai_code, paging);
			        
			        Map<String, Object> response = new HashMap<>();
			        response.put("body", pageEmpbyTail.getContent());
			        response.put("currentPage", pageEmpbyTail.getNumber());
			        response.put("totalItems", pageEmpbyTail.getTotalElements());
			        response.put("totalPages", pageEmpbyTail.getTotalPages());

			        return new ResponseEntity<>(response, HttpStatus.OK);
			      } catch (Exception e) {
			        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      }
				}
		
			
		//Paramètre Motif
		@GetMapping("/FaitEmpbyMotif")
		public ResponseEntity<Map<String,Object>> getAllemployeurByMotif(
				 @RequestParam(defaultValue = "2") int motcode,
				 @RequestParam(defaultValue = "0") int page, 
				 @RequestParam(defaultValue = "10") int size){
			
			try {
				
			      Pageable paging = PageRequest.of(page, size);
			      
			      Page<Ima_fait_employeur_transactionnel> pageEmpbyMotif;
		
			      pageEmpbyMotif = faitEmployeurTransactionnelRepository.FaitEmpMotif(motcode, paging);
			        
			        Map<String, Object> response = new HashMap<>();
			        response.put("body", pageEmpbyMotif.getContent());
			        response.put("currentPage", pageEmpbyMotif.getNumber());
			        response.put("totalItems", pageEmpbyMotif.getTotalElements());
			        response.put("totalPages", pageEmpbyMotif.getTotalPages());

			        return new ResponseEntity<>(response, HttpStatus.OK);
			      } catch (Exception e) {
			        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      }
			}
	
		//Paramètre Intervalle
		@GetMapping("/FaitEmpbyInterv")
		public ResponseEntity<Map<String,Object>> getAllemployeurByInterv(
				 @RequestParam(defaultValue = "2019-01-01") Date datedebut,
				 @RequestParam(defaultValue = "2019-12-31") Date datefin,
				 @RequestParam(defaultValue = "0") int page, 
				 @RequestParam(defaultValue = "10") int size){
			
			try {
		
			      Pageable paging = PageRequest.of(page, size);
			      
			      Page<Ima_fait_employeur_transactionnel> pageEmpbyInterv;
		
			      pageEmpbyInterv = faitEmployeurTransactionnelRepository.FaitEmpInterv(datedebut,datefin, paging);
			        
			        Map<String, Object> response = new HashMap<>();
			        response.put("body", pageEmpbyInterv.getContent());
			        response.put("currentPage", pageEmpbyInterv.getNumber());
			        response.put("totalItems", pageEmpbyInterv.getTotalElements());
			        response.put("totalPages", pageEmpbyInterv.getTotalPages());

			        return new ResponseEntity<>(response, HttpStatus.OK);
			      } catch (Exception e) {
			        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      }
				}
		
		

		//Paramètre Année et taille entreprise
		@GetMapping("/FaitEmpbyAnTail")
		public ResponseEntity<Map<String,Object>> getAllemployeurByAnTail(
				 @RequestParam(defaultValue = "2019") int no_annee,
				 @RequestParam(defaultValue = "10") int tai_code,
				 @RequestParam(defaultValue = "0") int page, 
				 @RequestParam(defaultValue = "10") int size){
			
			try {
		
			      Pageable paging = PageRequest.of(page, size);
			      
			      Page<Ima_fait_employeur_transactionnel> pageEmpbyAnTail;
		
			      pageEmpbyAnTail = faitEmployeurTransactionnelRepository.FaitEmpAnTail(no_annee,tai_code, paging);
			        
			        Map<String, Object> response = new HashMap<>();
			        response.put("body", pageEmpbyAnTail.getContent());
			        response.put("currentPage", pageEmpbyAnTail.getNumber());
			        response.put("totalItems", pageEmpbyAnTail.getTotalElements());
			        response.put("totalPages", pageEmpbyAnTail.getTotalPages());

			        return new ResponseEntity<>(response, HttpStatus.OK);
			      } catch (Exception e) {
			        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      }
				}
		
		
		//Paramètre Année et Motifs
		@GetMapping("/FaitEmpbyAnMotif")
		public ResponseEntity<Map<String,Object>> getAllemployeurByAnMotif(
				 @RequestParam(defaultValue = "2019") int no_annee,
				 @RequestParam(defaultValue = "2") int motcode,
				 @RequestParam(defaultValue = "0") int page, 
				 @RequestParam(defaultValue = "10") int size){
			
			try {
		
			      Pageable paging = PageRequest.of(page, size);
			      
			      Page<Ima_fait_employeur_transactionnel> pageEmpbyAnMotif;
		
			      pageEmpbyAnMotif = faitEmployeurTransactionnelRepository.FaitEmpAnMotif(no_annee,motcode, paging);
			        
			        Map<String, Object> response = new HashMap<>();
			        response.put("body", pageEmpbyAnMotif.getContent());
			        response.put("currentPage", pageEmpbyAnMotif.getNumber());
			        response.put("totalItems", pageEmpbyAnMotif.getTotalElements());
			        response.put("totalPages", pageEmpbyAnMotif.getTotalPages());

			        return new ResponseEntity<>(response, HttpStatus.OK);
			      } catch (Exception e) {
			        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      }
				}

		//Paramètre Taille et Motifs
		@GetMapping("/FaitEmpbyTailMotif")
		public ResponseEntity<Map<String,Object>> getAllemployeurByTailMotif(
				 @RequestParam(defaultValue = "10") int tai_code,
				 @RequestParam(defaultValue = "2") int motcode,
				 @RequestParam(defaultValue = "0") int page, 
				 @RequestParam(defaultValue = "10") int size){
			
			try {
		
			      Pageable paging = PageRequest.of(page, size);
			      
			      Page<Ima_fait_employeur_transactionnel> pageEmpbyTailMotif;
		
			      pageEmpbyTailMotif = faitEmployeurTransactionnelRepository.FaitEmpTailMotif(tai_code,motcode, paging);
			        
			        Map<String, Object> response = new HashMap<>();
			        response.put("body", pageEmpbyTailMotif.getContent());
			        response.put("currentPage", pageEmpbyTailMotif.getNumber());
			        response.put("totalItems", pageEmpbyTailMotif.getTotalElements());
			        response.put("totalPages", pageEmpbyTailMotif.getTotalPages());

			        return new ResponseEntity<>(response, HttpStatus.OK);
			      } catch (Exception e) {
			        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      }
				}
		
		//Paramètre Taille et intervalle de temps
		
		@GetMapping("/FaitEmpbyTailInterv")
		public ResponseEntity<Map<String,Object>> getAllemployeurByTailInterv(
				 @RequestParam(defaultValue = "10") int tai_code,
				 @RequestParam(defaultValue = "2019-01-01") Date datedebut,
				 @RequestParam(defaultValue = "2019-12-31") Date datefin,
				 @RequestParam(defaultValue = "0") int page, 
				 @RequestParam(defaultValue = "10") int size){
			
			try {
		
			      Pageable paging = PageRequest.of(page, size);
			      
			      Page<Ima_fait_employeur_transactionnel> pageEmpbyTailInterv;
		
			      pageEmpbyTailInterv = faitEmployeurTransactionnelRepository.FaitEmpTailInterv(tai_code, datedebut, datefin,paging);
			        
			        Map<String, Object> response = new HashMap<>();
			        response.put("body", pageEmpbyTailInterv.getContent());
			        response.put("currentPage", pageEmpbyTailInterv.getNumber());
			        response.put("totalItems", pageEmpbyTailInterv.getTotalElements());
			        response.put("totalPages", pageEmpbyTailInterv.getTotalPages());

			        return new ResponseEntity<>(response, HttpStatus.OK);
			      } catch (Exception e) {
			        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      }
				}
		
		//Paramètre Motif et intervalle de temps
		
		@GetMapping("/FaitEmpbyMotifInterv")
		public ResponseEntity<Map<String,Object>> getAllemployeurByMotifInterv(
				 @RequestParam(defaultValue = "2") int motcode,
				 @RequestParam(defaultValue = "2019-01-01") Date datedebut,
				 @RequestParam(defaultValue = "2019-12-31") Date datefin,
				 @RequestParam(defaultValue = "0") int page, 
				 @RequestParam(defaultValue = "10") int size){
			
			try {
		
			      Pageable paging = PageRequest.of(page, size);
			      
			      Page<Ima_fait_employeur_transactionnel> pageEmpbyMotifInterv;
		
			      pageEmpbyMotifInterv = faitEmployeurTransactionnelRepository.FaitEmpMotifInverv(motcode, datedebut, datefin,paging);
			        
			        Map<String, Object> response = new HashMap<>();
			        response.put("body", pageEmpbyMotifInterv.getContent());
			        response.put("currentPage", pageEmpbyMotifInterv.getNumber());
			        response.put("totalItems", pageEmpbyMotifInterv.getTotalElements());
			        response.put("totalPages", pageEmpbyMotifInterv.getTotalPages());

			        return new ResponseEntity<>(response, HttpStatus.OK);
			      } catch (Exception e) {
			        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      }
				}
		
		
		
		//Paramètre Année, Taille et Motif
		
		@GetMapping("/FaitEmpbyAnTailMotif")
		public ResponseEntity<Map<String,Object>> getAllemployeurByAnTailMotif(
				 @RequestParam(defaultValue = "2019") int no_annee,
				 @RequestParam(defaultValue = "10") int tai_code,
				 @RequestParam(defaultValue = "2") int motcode,
				 @RequestParam(defaultValue = "0") int page, 
				 @RequestParam(defaultValue = "10") int size){
			
			try {
		
			      Pageable paging = PageRequest.of(page, size);
			      
			      Page<Ima_fait_employeur_transactionnel> pageEmpbyAnTailMotif;
		
			      pageEmpbyAnTailMotif = faitEmployeurTransactionnelRepository.FaitEmpAnTailMotif(no_annee, tai_code, motcode, paging);
			        
			        Map<String, Object> response = new HashMap<>();
			        response.put("body", pageEmpbyAnTailMotif.getContent());
			        response.put("currentPage", pageEmpbyAnTailMotif.getNumber());
			        response.put("totalItems", pageEmpbyAnTailMotif.getTotalElements());
			        response.put("totalPages", pageEmpbyAnTailMotif.getTotalPages());

			        return new ResponseEntity<>(response, HttpStatus.OK);
			      } catch (Exception e) {
			        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      }
				}
		
		//Paramètre Taille, Motif et intervalle de temps
		
		@GetMapping("/FaitEmpbyTailMotifInterv")
		public ResponseEntity<Map<String,Object>> getAllemployeurByTailMotifInterv(
				 @RequestParam(defaultValue = "10") int tai_code,
				 @RequestParam(defaultValue = "2") int motcode,
				 @RequestParam(defaultValue = "2019-01-01") Date datedebut,
				 @RequestParam(defaultValue = "2019-12-31") Date datefin,
				 @RequestParam(defaultValue = "0") int page, 
				 @RequestParam(defaultValue = "10") int size){
			
			try {
		
			      Pageable paging = PageRequest.of(page, size);
			      
			      Page<Ima_fait_employeur_transactionnel> pageEmpbyTailMotifInterv;
		
			      pageEmpbyTailMotifInterv = faitEmployeurTransactionnelRepository.FaitEmpTailMotifInterv(tai_code, motcode, datedebut, datefin,paging);
			        
			        Map<String, Object> response = new HashMap<>();
			        response.put("body", pageEmpbyTailMotifInterv.getContent());
			        response.put("currentPage", pageEmpbyTailMotifInterv.getNumber());
			        response.put("totalItems", pageEmpbyTailMotifInterv.getTotalElements());
			        response.put("totalPages", pageEmpbyTailMotifInterv.getTotalPages());

			        return new ResponseEntity<>(response, HttpStatus.OK);
			      } catch (Exception e) {
			        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      }
				}
		
		
		//Paramètre Catégorie activité
		@GetMapping("/FaitEmpbyCat")
		public ResponseEntity<Map<String,Object>> getAllemployeurByCat(
				 @RequestParam(defaultValue = "2") int cat_code,
				 @RequestParam(defaultValue = "0") int page, 
				 @RequestParam(defaultValue = "10") int size){
			
			try {
				
			      Pageable paging = PageRequest.of(page, size);
			      
			      Page<Ima_fait_employeur_transactionnel> pageEmpbyMotif;
		
			      pageEmpbyMotif = faitEmployeurTransactionnelRepository.FaitEmpCat(cat_code, paging);
			        
			        Map<String, Object> response = new HashMap<>();
			        response.put("body", pageEmpbyMotif.getContent());
			        response.put("currentPage", pageEmpbyMotif.getNumber());
			        response.put("totalItems", pageEmpbyMotif.getTotalElements());
			        response.put("totalPages", pageEmpbyMotif.getTotalPages());

			        return new ResponseEntity<>(response, HttpStatus.OK);
			      } catch (Exception e) {
			        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			      }
			}

		//Paramètre Année et Catégorie
				@GetMapping("/FaitEmpbyAnCat")
				public ResponseEntity<Map<String,Object>> getAllemployeurByAnCat(
						 @RequestParam(defaultValue = "2019") int no_annee,
						 @RequestParam(defaultValue = "2") int cat_code,
						 @RequestParam(defaultValue = "0") int page, 
						 @RequestParam(defaultValue = "10") int size){
					
					try {
				
					      Pageable paging = PageRequest.of(page, size);
					      
					      Page<Ima_fait_employeur_transactionnel> pageEmpbyAnCat;
				
					      pageEmpbyAnCat = faitEmployeurTransactionnelRepository.FaitEmpAnCat(no_annee,cat_code, paging);
					        
					        Map<String, Object> response = new HashMap<>();
					        response.put("body", pageEmpbyAnCat.getContent());
					        response.put("currentPage", pageEmpbyAnCat.getNumber());
					        response.put("totalItems", pageEmpbyAnCat.getTotalElements());
					        response.put("totalPages", pageEmpbyAnCat.getTotalPages());

					        return new ResponseEntity<>(response, HttpStatus.OK);
					      } catch (Exception e) {
					        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					      }
						}
		
				//Paramètre Taille et Catégorie
				@GetMapping("/FaitEmpbyTailCat")
				public ResponseEntity<Map<String,Object>> getAllemployeurByTailCat(
						 @RequestParam(defaultValue = "10") int tai_code,
						 @RequestParam(defaultValue = "2") int cat_code,
						 @RequestParam(defaultValue = "0") int page, 
						 @RequestParam(defaultValue = "10") int size){
					
					try {
				
					      Pageable paging = PageRequest.of(page, size);
					      
					      Page<Ima_fait_employeur_transactionnel> pageEmpbyTailCat;
				
					      pageEmpbyTailCat = faitEmployeurTransactionnelRepository.FaitEmpTailCat(tai_code,cat_code, paging);
					        
					        Map<String, Object> response = new HashMap<>();
					        response.put("body", pageEmpbyTailCat.getContent());
					        response.put("currentPage", pageEmpbyTailCat.getNumber());
					        response.put("totalItems", pageEmpbyTailCat.getTotalElements());
					        response.put("totalPages", pageEmpbyTailCat.getTotalPages());

					        return new ResponseEntity<>(response, HttpStatus.OK);
					      } catch (Exception e) {
					        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					      }
						}
				

				//Paramètre Motifs et Catégorie
				@GetMapping("/FaitEmpbyMotifCat")
				public ResponseEntity<Map<String,Object>> getAllemployeurByMotifCat(
						 @RequestParam(defaultValue = "10") int motcode,
						 @RequestParam(defaultValue = "2") int cat_code,
						 @RequestParam(defaultValue = "0") int page, 
						 @RequestParam(defaultValue = "10") int size){
					
					try {
				
					      Pageable paging = PageRequest.of(page, size);
					      
					      Page<Ima_fait_employeur_transactionnel> pageEmpbyMotifCat;
				
					      pageEmpbyMotifCat = faitEmployeurTransactionnelRepository.FaitEmpMotifCat(motcode,cat_code, paging);
					        
					        Map<String, Object> response = new HashMap<>();
					        response.put("body", pageEmpbyMotifCat.getContent());
					        response.put("currentPage", pageEmpbyMotifCat.getNumber());
					        response.put("totalItems", pageEmpbyMotifCat.getTotalElements());
					        response.put("totalPages", pageEmpbyMotifCat.getTotalPages());

					        return new ResponseEntity<>(response, HttpStatus.OK);
					      } catch (Exception e) {
					        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					      }
						}
				
				
				//Paramètre Catégorie et intervalle de temps
				
				@GetMapping("/FaitEmpbyCatInterv")
				public ResponseEntity<Map<String,Object>> getAllemployeurByCatInterv(
						 @RequestParam(defaultValue = "2") int cat_code,
						 @RequestParam(defaultValue = "2019-01-01") Date datedebut,
						 @RequestParam(defaultValue = "2019-12-31") Date datefin,
						 @RequestParam(defaultValue = "0") int page, 
						 @RequestParam(defaultValue = "10") int size){
					
					try {
				
					      Pageable paging = PageRequest.of(page, size);
					      
					      Page<Ima_fait_employeur_transactionnel> pageEmpbyCatInterv;
				
					      pageEmpbyCatInterv = faitEmployeurTransactionnelRepository.FaitEmpCatInverv(cat_code, datedebut, datefin,paging);
					        
					        Map<String, Object> response = new HashMap<>();
					        response.put("body", pageEmpbyCatInterv.getContent());
					        response.put("currentPage", pageEmpbyCatInterv.getNumber());
					        response.put("totalItems", pageEmpbyCatInterv.getTotalElements());
					        response.put("totalPages", pageEmpbyCatInterv.getTotalPages());

					        return new ResponseEntity<>(response, HttpStatus.OK);
					      } catch (Exception e) {
					        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					      }
						}
			
				//Paramètre Année + Taille et Catégorie
				@GetMapping("/FaitEmpbyAnTailCat")
				public ResponseEntity<Map<String,Object>> getAllemployeurByAnTailCat(
						 @RequestParam(defaultValue = "2019") int no_annee,
						 @RequestParam(defaultValue = "10") int tai_code,
						 @RequestParam(defaultValue = "2") int cat_code,
						 @RequestParam(defaultValue = "0") int page, 
						 @RequestParam(defaultValue = "10") int size){
					
					try {
				
					      Pageable paging = PageRequest.of(page, size);
					      
					      Page<Ima_fait_employeur_transactionnel> pageEmpbyAnTailCat;
				
					      pageEmpbyAnTailCat = faitEmployeurTransactionnelRepository.FaitEmpAnTailCat(no_annee, tai_code, cat_code, paging);
					        
					        Map<String, Object> response = new HashMap<>();
					        response.put("body", pageEmpbyAnTailCat.getContent());
					        response.put("currentPage", pageEmpbyAnTailCat.getNumber());
					        response.put("totalItems", pageEmpbyAnTailCat.getTotalElements());
					        response.put("totalPages", pageEmpbyAnTailCat.getTotalPages());

					        return new ResponseEntity<>(response, HttpStatus.OK);
					      } catch (Exception e) {
					        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					      }
						}

				//Paramètre Année et Catégorie + Motifs
				@GetMapping("/FaitEmpbyAnCatMotif")
				public ResponseEntity<Map<String,Object>> getAllemployeurByAnCatMotif(
						 @RequestParam(defaultValue = "2019") int no_annee,
						 @RequestParam(defaultValue = "2") int cat_code,
						 @RequestParam(defaultValue = "2") int motcode,
						 @RequestParam(defaultValue = "0") int page, 
						 @RequestParam(defaultValue = "10") int size){
					
					try {
				
					      Pageable paging = PageRequest.of(page, size);
					      
					      Page<Ima_fait_employeur_transactionnel> pageEmpbyAnCatMotif;
				
					      pageEmpbyAnCatMotif = faitEmployeurTransactionnelRepository.FaitEmpAnTailCat(no_annee, cat_code,motcode , paging);
					        
					        Map<String, Object> response = new HashMap<>();
					        response.put("body", pageEmpbyAnCatMotif.getContent());
					        response.put("currentPage", pageEmpbyAnCatMotif.getNumber());
					        response.put("totalItems", pageEmpbyAnCatMotif.getTotalElements());
					        response.put("totalPages", pageEmpbyAnCatMotif.getTotalPages());

					        return new ResponseEntity<>(response, HttpStatus.OK);
					      } catch (Exception e) {
					        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					      }
						}
				
				
				//Paramètre Catégorie + Motif et intervalle de temps
				@GetMapping("/FaitEmpbyCatMotifInterv")
				public ResponseEntity<Map<String,Object>> getAllemployeurByCatMotifInterv(
						 @RequestParam(defaultValue = "2") int cat_code,
						 @RequestParam(defaultValue = "2") int motcode,
						 @RequestParam(defaultValue = "2019-01-01") Date datedebut,
						 @RequestParam(defaultValue = "2019-12-31") Date datefin,
						 @RequestParam(defaultValue = "0") int page, 
						 @RequestParam(defaultValue = "10") int size){
					
					try {
				
					      Pageable paging = PageRequest.of(page, size);
					      
					      Page<Ima_fait_employeur_transactionnel> pageEmpbyCatMotifInterv;
				
					      pageEmpbyCatMotifInterv = faitEmployeurTransactionnelRepository.FaitEmpCatMotifInterv(cat_code,motcode , datedebut, datefin,paging);
					        
					        Map<String, Object> response = new HashMap<>();
					        response.put("body", pageEmpbyCatMotifInterv.getContent());
					        response.put("currentPage", pageEmpbyCatMotifInterv.getNumber());
					        response.put("totalItems", pageEmpbyCatMotifInterv.getTotalElements());
					        response.put("totalPages", pageEmpbyCatMotifInterv.getTotalPages());

					        return new ResponseEntity<>(response, HttpStatus.OK);
					      } catch (Exception e) {
					        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					      }
						}
			
				//Paramètre Catégorie + Taille et intervalle de temps
				@GetMapping("/FaitEmpbyCatTailInterv")
				public ResponseEntity<Map<String,Object>> getAllemployeurByCatTailInterv(
						 @RequestParam(defaultValue = "2") int cat_code,
						 @RequestParam(defaultValue = "10") int tai_code,
						 @RequestParam(defaultValue = "2019-01-01") Date datedebut,
						 @RequestParam(defaultValue = "2019-12-31") Date datefin,
						 @RequestParam(defaultValue = "0") int page, 
						 @RequestParam(defaultValue = "10") int size){
					
					try {
				
					      Pageable paging = PageRequest.of(page, size);
					      
					      Page<Ima_fait_employeur_transactionnel> pageEmpbyCatTailInterv;
				
					      pageEmpbyCatTailInterv = faitEmployeurTransactionnelRepository.FaitEmpCatTailnterv(cat_code,tai_code , datedebut, datefin,paging);
					        
					        Map<String, Object> response = new HashMap<>();
					        response.put("body", pageEmpbyCatTailInterv.getContent());
					        response.put("currentPage", pageEmpbyCatTailInterv.getNumber());
					        response.put("totalItems", pageEmpbyCatTailInterv.getTotalElements());
					        response.put("totalPages", pageEmpbyCatTailInterv.getTotalPages());

					        return new ResponseEntity<>(response, HttpStatus.OK);
					      } catch (Exception e) {
					        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					      }
						}
			
				//Paramètre Catégorie + Taille + Motif et intervalle de temps
				@GetMapping("/FaitEmpbyCatTailMotifInterv")
				public ResponseEntity<Map<String,Object>> getAllemployeurByCatTailMotifInterv(
						 @RequestParam(defaultValue = "2") int cat_code,
						 @RequestParam(defaultValue = "10") int tai_code,
						 @RequestParam(defaultValue = "2") int motcode,
						 @RequestParam(defaultValue = "2019-01-01") Date datedebut,
						 @RequestParam(defaultValue = "2019-12-31") Date datefin,
						 @RequestParam(defaultValue = "0") int page, 
						 @RequestParam(defaultValue = "10") int size){
					
					try {
				
					      Pageable paging = PageRequest.of(page, size);
					      
					      Page<Ima_fait_employeur_transactionnel> pageEmpbyCatTailMotifInterv;
				
					      pageEmpbyCatTailMotifInterv = faitEmployeurTransactionnelRepository.FaitEmpCatTailMotifInterv(cat_code,tai_code ,motcode , datedebut, datefin,paging);
					        
					        Map<String, Object> response = new HashMap<>();
					        response.put("body", pageEmpbyCatTailMotifInterv.getContent());
					        response.put("currentPage", pageEmpbyCatTailMotifInterv.getNumber());
					        response.put("totalItems", pageEmpbyCatTailMotifInterv.getTotalElements());
					        response.put("totalPages", pageEmpbyCatTailMotifInterv.getTotalPages());

					        return new ResponseEntity<>(response, HttpStatus.OK);
					      } catch (Exception e) {
					        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					      }
						}		
				
				//Paramètre Catégorie + Taille + Motif et Annee
				@GetMapping("/FaitEmpbyCatTailMotifDate")
				public ResponseEntity<Map<String,Object>> getAllemployeurByCatTailMotifAnn(
						 @RequestParam(defaultValue = "2") int cat_code,
						 @RequestParam(defaultValue = "10") int tai_code,
						 @RequestParam(defaultValue = "2") int motcode,
						 @RequestParam(defaultValue = "2019") int no_annee,
						 @RequestParam(defaultValue = "0") int page, 
						 @RequestParam(defaultValue = "10") int size){
					
					try {
				
					      Pageable paging = PageRequest.of(page, size);
					      
					      Page<Ima_fait_employeur_transactionnel> pageEmpbyCatTailMotifAnn;
				
					      pageEmpbyCatTailMotifAnn = faitEmployeurTransactionnelRepository.FaitEmpCatTailMotifAn(cat_code,tai_code ,motcode, no_annee,paging);
					        
					        Map<String, Object> response = new HashMap<>();
					        response.put("body", pageEmpbyCatTailMotifAnn.getContent());
					        response.put("currentPage", pageEmpbyCatTailMotifAnn.getNumber());
					        response.put("totalItems", pageEmpbyCatTailMotifAnn.getTotalElements());
					        response.put("totalPages", pageEmpbyCatTailMotifAnn.getTotalPages());

					        return new ResponseEntity<>(response, HttpStatus.OK);
					      } catch (Exception e) {
					        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					      }
						}	
				
				
				//Paramètre Catégorie + Taille + Motif 
				@GetMapping("/FaitEmpbyCatTailMotif")
				public ResponseEntity<Map<String,Object>> getAllemployeurByCatTailMotif(
						 @RequestParam(defaultValue = "2") int cat_code,
						 @RequestParam(defaultValue = "10") int tai_code,
						 @RequestParam(defaultValue = "2") int motcode,
						 @RequestParam(defaultValue = "0") int page, 
						 @RequestParam(defaultValue = "10") int size){
					
					try {
				
					      Pageable paging = PageRequest.of(page, size);
					      
					      Page<Ima_fait_employeur_transactionnel> pageEmpbyCatTailMotif;
				
					      pageEmpbyCatTailMotif = faitEmployeurTransactionnelRepository.FaitEmpCatTailMotif(cat_code,tai_code ,motcode,paging);
					        
					        Map<String, Object> response = new HashMap<>();
					        response.put("body", pageEmpbyCatTailMotif.getContent());
					        response.put("currentPage", pageEmpbyCatTailMotif.getNumber());
					        response.put("totalItems", pageEmpbyCatTailMotif.getTotalElements());
					        response.put("totalPages", pageEmpbyCatTailMotif.getTotalPages());

					        return new ResponseEntity<>(response, HttpStatus.OK);
					      } catch (Exception e) {
					        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					      }
						}						
}
