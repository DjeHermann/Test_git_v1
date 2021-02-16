package com.osis.cipres.immatriculation.repositories;

import java.sql.Date;
import java.util.List; 

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.osis.cipres.immatriculation.jsonForm.Tableau1Details;
import com.osis.cipres.immatriculation.jsonForm.Tableau2Details_NI;
import com.osis.cipres.immatriculation.jsonForm.Tableau2Details_Radie;
import com.osis.cipres.immatriculation.jsonForm.Tableau2Details_Reactive;
import com.osis.cipres.immatriculation.jsonForm.Tableau2Details_Suspendus;
import com.osis.cipres.immatriculation.jsonForm.Tableau2_1;
import com.osis.cipres.immatriculation.jsonForm.Tableau2_1Details;
import com.osis.cipres.immatriculation.jsonForm.Tableau2_NI;
import com.osis.cipres.immatriculation.jsonForm.Tableau3Details_NI;
import com.osis.cipres.immatriculation.jsonForm.Tableau3Details_Radie;
import com.osis.cipres.immatriculation.jsonForm.Tableau3Details_Reactive;
import com.osis.cipres.immatriculation.jsonForm.Tableau3Details_Suspendus;
import com.osis.cipres.immatriculation.jsonForm.Tableau3_1Details;
import com.osis.cipres.immatriculation.jsonForm.Tableau4;
import com.osis.cipres.immatriculation.jsonForm.Tableau4Details;
import com.osis.cipres.immatriculation.tables.Ima_fait_employeur_transactionnel;

public interface FaitEmployeurTransactionnelRepository extends JpaRepository<Ima_fait_employeur_transactionnel, Long> {
	

    //	
	@Query("select c from Ima_fait_employeur_transactionnel c order by c.fk_date_motif desc")
	public List<Ima_fait_employeur_transactionnel> getFaitList(Pageable pageable );
	


	
	//************************************************  TABLEAU 1   ******************************************//
	
	//Requêtes pour les données du tableau 1 **** les details //
			@Query("Select distinct(cle_fait_transactionnel_employeur) as nouvelleImmatriculation,"
					+ " c.fk_dim_cat_activite.cat_libelle as catLibelle,"
					+ " c.fk_dim_employeur.emp_raison_sociale as employeur,"
					+ " c.fk_dim_taille_employeur.tai_libelle as taiLibelle,"
					+ " c.fk_dim_secactivite.seclibel as secteurLibelle,"
					+ " c.fk_date_motif.date_complete as dateImmatriculation"
					+ " From Ima_fait_employeur_transactionnel c"
					+ " Where c.fk_date_motif.no_annee=:no_annee "
					+ " and c.fk_dim_cat_activite.cat_libelle=:cat_libelle"
					+ " and c.fk_date_motif.no_mois=:no_mois and c.fk_dim_motif.motcode=90")
					
		public List<Tableau1Details> Tableau1Details(@Param("no_annee")int no_annee, @Param("cat_libelle")String cat_libelle,@Param("no_mois")int no_mois);
			
	//************************************************  TABLEAU 2  ******************************************//	
			
			 //Requêtes pour tableau 2 partie1 *** Details //
			@Query("Select distinct(cle_fait_transactionnel_employeur) as nouvelleImmatriculation,"
					+ " c.fk_dim_secactivite.seclibel as secteurLibelle,"
					+ " c.fk_dim_employeur.emp_raison_sociale as employeur,"
					+ " c.fk_date_motif.date_complete as dateImmatriculation,"
					+ "	c.fk_dim_cat_activite.cat_libelle as catLibelle"
					+ " From Ima_fait_employeur_transactionnel c Where "
					+ " c.fk_dim_employeur.emp_date_dernier_motif <=:periode and c.fk_dim_employeur.emp_dernier_motif=1 and"
					+ " c.fk_dim_cat_activite.cat_libelle=:cat_libelle"
					)
			public List<Tableau2_1Details> Tableau2DetailsActifDebutPeriode(@Param("periode")Date periode,@Param("cat_libelle")String cat_libelle);
		
			
			
			 //Requêtes pour tableau 2 Details / Nouvelle immatriculation/
			@Query("Select distinct(cle_fait_transactionnel_employeur) as nouvelleImmatriculation,"
					//+ " c.fk_dim_secactivite.seclibel as secteurLibelle,"
					+ " c.fk_dim_employeur.emp_raison_sociale as employeur,"
					+ " c.fk_date_motif.date_complete as dateImmatriculation,"
					+ "	c.fk_dim_cat_activite.cat_libelle as catLibelle"
					+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and"
					+ " c.fk_dim_cat_activite.cat_libelle=:cat_libelle and c.fk_dim_motif.motcode=90"
					)
			public List<Tableau2Details_NI> Tableau2DetailsNI(@Param("no_annee")int no_annee,@Param("cat_libelle")String cat_libelle);
			
			
			
		 
			//Requêtes pour tableau 2 Details /employeur reactivé/
			@Query("Select c.nombre_employeur_reactive as employeurReactive,"
					+ " c.fk_dim_secactivite.seclibel as secteurLibelle,"
					+ " c.fk_dim_employeur.emp_raison_sociale as employeur,"
					+ " c.fk_date_motif.date_complete as dateImmatriculation,"
					+ "	c.fk_dim_cat_activite.cat_libelle as catLibelle"
					+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and"
					+ " c.fk_dim_cat_activite.cat_libelle=:cat_libelle and c.nombre_employeur_reactive =1"
					)
			public List<Tableau2Details_Reactive> Tableau2DetailsReactive(@Param("no_annee")int no_annee,@Param("cat_libelle")String cat_libelle);
		 
			
			//Requêtes pour tableau 2 Details /employeur Suspendus/
			@Query("Select c.nombre_employeur_suspendu as employeurSuspendus,"
					+ " c.fk_dim_secactivite.seclibel as secteurLibelle,"
					+ " c.fk_dim_employeur.emp_raison_sociale as employeur,"
					+ " c.fk_date_motif.date_complete as dateImmatriculation,"
					+ "	c.fk_dim_cat_activite.cat_libelle as catLibelle"
					+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and"
					+ " c.fk_dim_cat_activite.cat_libelle=:cat_libelle and c.nombre_employeur_suspendu =1"
					)
			public List<Tableau2Details_Suspendus> Tableau2DetailsSuspendus(@Param("no_annee")int no_annee,@Param("cat_libelle")String cat_libelle);
		 
			
			//Requêtes pour tableau 2 Details /employeur Radie/
			@Query("Select c.nombre_employeur_radie as employeurRadie,"
					+ " c.fk_dim_secactivite.seclibel as secteurLibelle,"
					+ " c.fk_dim_employeur.emp_raison_sociale as employeur,"
					+ " c.fk_date_motif.date_complete as dateImmatriculation,"
					+ "	c.fk_dim_cat_activite.cat_libelle as catLibelle"
					+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and"
					+ " c.fk_dim_cat_activite.cat_libelle=:cat_libelle and c.nombre_employeur_radie =1"
					)
			public List<Tableau2Details_Radie> Tableau2DetailsRadie(@Param("no_annee")int no_annee,@Param("cat_libelle")String cat_libelle);
		 
//************************************************  TABLEAU 3   ******************************************//
			
			 //Requêtes pour tableau 3 partie1 *** Details //
			@Query("Select distinct(cle_fait_transactionnel_employeur) as nouvelleImmatriculation,"
					+ " c.fk_dim_secactivite.seclibel as secteurLibelle,"
					+ " c.fk_date_motif.date_complete as dateImmatriculation,"
					+ " c.fk_dim_employeur.emp_raison_sociale as employeur"
					+ " From Ima_fait_employeur_transactionnel c Where"
					+ " c.fk_dim_employeur.emp_date_dernier_motif <=:periode and c.fk_dim_employeur.emp_dernier_motif=1 and"
					+ " c.fk_dim_secactivite.seclibel=:seclibel" 
					)
			public List<Tableau3_1Details> Tableau3DetailsActifDebutPeriode(@Param("periode")Date periode,@Param("seclibel")String seclibel);
		
			
			
			 //Requêtes pour tableau 3 Details / Nouvelle immatriculation/
			@Query("Select distinct(cle_fait_transactionnel_employeur) as nouvelleImmatriculation,"
					+ " c.fk_dim_secactivite.seclibel as secteurLibelle,"
					+ " c.fk_dim_employeur.emp_raison_sociale as employeur,"
					+ " c.fk_date_motif.date_complete as dateImmatriculation"
					+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and"
					+ " c.fk_dim_secactivite.seclibel=:seclibel and c.fk_dim_motif.motcode=90"
					)
			public List<Tableau3Details_NI> Tableau3DetailsNI(@Param("no_annee")int no_annee,@Param("seclibel")String seclibel);
		 
			//Requêtes pour tableau 3 Details /employeur reactivé/
			@Query("Select c.nombre_employeur_reactive as employeurReactive,"
					+ " c.fk_dim_secactivite.seclibel as secteurLibelle,"
					+ " c.fk_dim_employeur.emp_raison_sociale as employeur,"
					+ " c.fk_date_motif.date_complete as dateImmatriculation"
					+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and"
					+ " c.fk_dim_secactivite.seclibel=:seclibel and c.nombre_employeur_reactive =1"
					)
			public List<Tableau3Details_Reactive> Tableau3DetailsReactive(@Param("no_annee")int no_annee,@Param("seclibel")String seclibel);
		 
			
			//Requêtes pour tableau 3 Details /employeur Suspendus/
			@Query("Select c.nombre_employeur_suspendu as employeurSuspendus,"
					+ " c.fk_dim_secactivite.seclibel as secteurLibelle,"
					+ " c.fk_dim_employeur.emp_raison_sociale as employeur,"
					+ " c.fk_date_motif.date_complete as dateImmatriculation"
					+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and"
					+ " c.fk_dim_secactivite.seclibel=:seclibel and c.nombre_employeur_suspendu =1"
					)
			public List<Tableau3Details_Suspendus> Tableau3DetailsSuspendus(@Param("no_annee")int no_annee,@Param("seclibel")String seclibel);
		 
			
			//Requêtes pour tableau 3 Details /employeur Radie/
			@Query("Select c.nombre_employeur_radie as employeurRadie,"
					+ " c.fk_dim_secactivite.seclibel as secteurLibelle,"
					+ " c.fk_dim_employeur.emp_raison_sociale as employeur,"
					+ " c.fk_date_motif.date_complete as dateImmatriculation"
					+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and"
					+ " c.fk_dim_secactivite.seclibel=:seclibel and c.nombre_employeur_radie =1"
					)
			public List<Tableau3Details_Radie> Tableau3DetailsRadie(@Param("no_annee")int no_annee,@Param("seclibel")String seclibel);
		 

			//************************************************  TABLEAU 4   ******************************************//
			
			 //Requêtes pour tableau 4 *** Details //
			
			@Query("Select c.fk_dim_employeur.emp_raison_sociale as employeur,"
					+ " c.fk_dim_cat_activite.cat_libelle as catLibelle,"
					+ " c.fk_dim_secactivite.seclibel as secteurLibelle,"
					+ " c.fk_dim_taille_employeur.tai_libelle as tailleLibelle,"
					+ " c.fk_date_motif.no_annee as noAnnee,"
					+ " c.fk_date_motif.date_complete as dateImmatriculation"
					+ " From Ima_fait_employeur_transactionnel c"
					+ " Where c.fk_date_motif.no_annee=:no_annee and c.fk_date_motif.cle_date !=-4 and"
					+ " c.fk_dim_cat_activite.cat_libelle=:cat_libelle")			
			public List<Tableau4Details> Tableau4Details(@Param("no_annee")int no_annee,@Param("cat_libelle")String cat_libelle);

			
			
//******************************************************REQUETE ANALYSE*************************************************//
			//Paramètre année
			@Query("Select c From Ima_fait_employeur_mensuel c Where c.fk_date_motif.no_annee=:no_annee")
			Page<Ima_fait_employeur_transactionnel> FaitEmpAn(@Param("no_annee")int no_annee,Pageable pageable);
			
			//Paramètre Taille entreprise
			@Query("Select c From Ima_fait_employeur_mensuel c Where c.fk_dim_taille_employeur.tai_code=:tai_code")
			Page<Ima_fait_employeur_transactionnel> FaitEmpTail(@Param("tai_code")int tai_code,Pageable pageable);
			
			//Paramètre Motif
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_dim_motif.motcode=:motcode ")
			Page<Ima_fait_employeur_transactionnel> FaitEmpMotif(@Param("motcode")int motcode,Pageable pageable);
			
			//Paramètre Catégorie activité
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_dim_cat_activite.cat_code=:cat_code ")
			Page<Ima_fait_employeur_transactionnel> FaitEmpCat(@Param("cat_code")int cat_code,Pageable pageable);
						
			//Paramètre Intervalle de temps
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.date_complete between :datedebut and :datefin")
			Page<Ima_fait_employeur_transactionnel> FaitEmpInterv(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin,Pageable pageable);
						
			//Paramètre Année + taille
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and c.fk_dim_taille_employeur.tai_code=:tai_code")
			Page<Ima_fait_employeur_transactionnel> FaitEmpAnTail(@Param("no_annee")int no_annee,@Param("tai_code")int tai_code,Pageable pageable);
				
			//Paramètre Année + motif
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and c.fk_dim_motif.motcode=:motcode")
			Page<Ima_fait_employeur_transactionnel> FaitEmpAnMotif(@Param("no_annee")int no_annee,@Param("motcode")int motcode,Pageable pageable);
			
			//Paramètre Année + Catégorie activité
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and c.fk_dim_cat_activite.cat_code=:cat_code")
			Page<Ima_fait_employeur_transactionnel> FaitEmpAnCat(@Param("no_annee")int no_annee,@Param("cat_code")int cat_code,Pageable pageable);
						
			//Paramètre Taille + motif
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_dim_taille_employeur.tai_code=:tai_code and c.fk_dim_motif.motcode=:motcode")
			Page<Ima_fait_employeur_transactionnel> FaitEmpTailMotif(@Param("tai_code")int tai_code,@Param("motcode")int motcode,Pageable pageable);
			
			//Paramètre Taille + Catégorie activité
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_dim_taille_employeur.tai_code=:tai_code and c.fk_dim_cat_activite.cat_code=:cat_code")
			Page<Ima_fait_employeur_transactionnel> FaitEmpTailCat(@Param("tai_code")int tai_code,@Param("cat_code")int cat_code,Pageable pageable);
			
			//Paramètre Motif + Catégorie activité
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_dim_cat_activite.cat_code=:cat_code and c.fk_dim_motif.motcode=:motcode")
			Page<Ima_fait_employeur_transactionnel> FaitEmpMotifCat(@Param("cat_code")int cat_code,@Param("motcode")int motcode,Pageable pageable);
						
			//Paramètre Taille + intervalle de temps
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_dim_taille_employeur.tai_code=:tai_code and c.fk_date_motif.date_complete between :datedebut and :datefin")
			Page<Ima_fait_employeur_transactionnel> FaitEmpTailInterv(@Param("tai_code")int tai_code,@Param("datedebut")Date datedebut,@Param("datefin")Date datefin,Pageable pageable);
				
			//Paramètre Motif + intervalle de temps
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_dim_motif.motcode=:motcode and c.fk_date_motif.date_complete between :datedebut and :datefin")
			Page<Ima_fait_employeur_transactionnel> FaitEmpMotifInverv(@Param("motcode")int motcode,@Param("datedebut")Date datedebut,@Param("datefin")Date datefin,Pageable pageable);
			
			//Paramètre Catégorie activité + intervalle de temps
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_dim_cat_activite.cat_code=:cat_code and c.fk_date_motif.date_complete between :datedebut and :datefin")
			Page<Ima_fait_employeur_transactionnel> FaitEmpCatInverv(@Param("cat_code")int cat_code,@Param("datedebut")Date datedebut,@Param("datefin")Date datefin,Pageable pageable);
				
			//Paramètre Annee + taille + Catégorie activité
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and c.fk_dim_taille_employeur.tai_code=:tai_code and c.fk_dim_cat_activite.cat_code=:cat_code")
			Page<Ima_fait_employeur_transactionnel> FaitEmpAnTailCat(@Param("no_annee")int no_annee,@Param("tai_code")int tai_code,@Param("cat_code")int cat_code,Pageable pageable);
			
			//Paramètre Annee + taille + motif
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and c.fk_dim_taille_employeur.tai_code=:tai_code and c.fk_dim_motif.motcode=:motcode")
			Page<Ima_fait_employeur_transactionnel> FaitEmpAnTailMotif(@Param("no_annee")int no_annee,@Param("tai_code")int tai_code,@Param("motcode")int motcode,Pageable pageable);
			
			//Paramètre Catégorie + taille + motif
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_dim_cat_activite.cat_code=:cat_code and c.fk_dim_taille_employeur.tai_code=:tai_code and c.fk_dim_motif.motcode=:motcode")
			Page<Ima_fait_employeur_transactionnel> FaitEmpCatTailMotif(@Param("cat_code")int cat_code,@Param("tai_code")int tai_code,@Param("motcode")int motcode,Pageable pageable);
			
			
			//Paramètre Annee + Catégorie + motif
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and c.fk_dim_cat_activite.cat_code=:cat_code and c.fk_dim_motif.motcode=:motcode")
			Page<Ima_fait_employeur_transactionnel> FaitEmpAnCatMotif(@Param("no_annee")int no_annee,@Param("cat_code")int cat_code,@Param("motcode")int motcode,Pageable pageable);
			
			//Paramètre taille + motif + Intervalle de temps
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_dim_taille_employeur.tai_code=:tai_code and c.fk_dim_motif.motcode=:motcode and c.fk_date_motif.date_complete between :datedebut and :datefin")
			Page<Ima_fait_employeur_transactionnel> FaitEmpTailMotifInterv(@Param("tai_code")int tai_code,@Param("motcode")int motcode,@Param("datedebut")Date datedebut,@Param("datefin")Date datefin,Pageable pageable);
						
			//Paramètre Categorie activité + motif + Intervalle de temps
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_dim_cat_activite.cat_code=:cat_code and c.fk_dim_motif.motcode=:motcode and c.fk_date_motif.date_complete between :datedebut and :datefin")
			Page<Ima_fait_employeur_transactionnel> FaitEmpCatMotifInterv(@Param("cat_code")int cat_code,@Param("motcode")int motcode,@Param("datedebut")Date datedebut,@Param("datefin")Date datefin,Pageable pageable);
				
			//Paramètre Categorie activité + Taille + Intervalle de temps
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_dim_taille_employeur.tai_code=:tai_code and c.fk_dim_cat_activite.cat_code=:cat_code and c.fk_date_motif.date_complete between :datedebut and :datefin")
			Page<Ima_fait_employeur_transactionnel> FaitEmpCatTailnterv(@Param("cat_code")int cat_code,@Param("tai_code")int tai_code,@Param("datedebut")Date datedebut,@Param("datefin")Date datefin,Pageable pageable);
			
			//Paramètre Categorie activité + Taille + Motifs + Intervalle de temps
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_dim_taille_employeur.tai_code=:tai_code and c.fk_dim_cat_activite.cat_code=:cat_code and c.fk_dim_motif.motcode=:motcode and c.fk_date_motif.date_complete between :datedebut and :datefin")
			Page<Ima_fait_employeur_transactionnel> FaitEmpCatTailMotifInterv(@Param("cat_code")int cat_code,@Param("tai_code")int tai_code,@Param("motcode")int motcode,@Param("datedebut")Date datedebut,@Param("datefin")Date datefin,Pageable pageable);
			
			//Paramètre Categorie activité + Taille + Motifs + Année
			@Query("Select c From Ima_fait_employeur_transactionnel c Where c.fk_dim_taille_employeur.tai_code=:tai_code and c.fk_dim_cat_activite.cat_code=:cat_code and c.fk_dim_motif.motcode=:motcode and c.fk_date_motif.no_annee=:no_annee")
			Page<Ima_fait_employeur_transactionnel> FaitEmpCatTailMotifAn(@Param("cat_code")int cat_code,@Param("tai_code")int tai_code,@Param("motcode")int motcode,@Param("no_annee")int no_annee,Pageable pageable);
			
}
