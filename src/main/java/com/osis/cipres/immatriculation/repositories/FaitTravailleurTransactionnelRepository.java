package com.osis.cipres.immatriculation.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.osis.cipres.immatriculation.tables.Ima_fait_travailleur_transactionnel;
import com.osis.cipres.immatriculation.jsonForm.Tableau10;
import com.osis.cipres.immatriculation.jsonForm.Tableau5;
import com.osis.cipres.immatriculation.jsonForm.Tableau6_1;
import com.osis.cipres.immatriculation.jsonForm.Tableau6_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau6_NI;
import com.osis.cipres.immatriculation.jsonForm.Tableau7_1;
import com.osis.cipres.immatriculation.jsonForm.Tableau7_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau8;
import com.osis.cipres.immatriculation.jsonForm.VgTravailleurActif;
import com.osis.cipres.immatriculation.jsonForm.VgTravailleurDecede;
import com.osis.cipres.immatriculation.jsonForm.VgTravailleurRetraite;
import com.osis.cipres.immatriculation.jsonForm.VgTravailleurAutreMotifs;
import com.osis.cipres.immatriculation.jsonForm.VueGlobalTotalTravailleur;
public interface FaitTravailleurTransactionnelRepository extends JpaRepository<Ima_fait_travailleur_transactionnel, Long>{
	
	//************************************************* REQUETE POUR VUE GLOBALE  TRAVAILLEUR*********************************************//

	///////////////////////////////////// Nouvelle immatriculation	
		
		//Nouvelles immatriculations
		@Query("Select sum(c.nombre_travailleur_nouvelle_immatriculation) as nouvelleImmatriculation,"
		+ "	c.fk_dim_cat_activite.cat_libelle as catLibelle"
		+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_immatriculation.no_annee=:no_annee"
		+ " group by catLibelle"
		)
		public List<Tableau6_NI> vueGlobalTravailleurNI(@Param("no_annee")int no_annee);
	
		
		// Nouvelle immatriculation/ Intervalle de temps
		@Query("Select sum(c.nombre_travailleur_nouvelle_immatriculation) as nouvelleImmatriculation,"
		+ "	c.fk_dim_cat_activite.cat_libelle as catLibelle"
		+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_immatriculation.date_complete between :datedebut AND :datefin"
		+ " group by catLibelle"
		)
		public List<Tableau6_NI> vueGlobalTravailleurIntervNI(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin);
		
		
		// Nouvelle immatriculation/ Date complète
		
		@Query("Select sum(c.nombre_travailleur_nouvelle_immatriculation) as nouvelleImmatriculation,"
		+ "	c.fk_dim_cat_activite.cat_libelle as catLibelle"
		+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_immatriculation.date_complete=:date_complete"
		+ " group by catLibelle"
		)
		public List<Tableau6_NI> vueGlobalTravailleurDateNI(@Param("date_complete")Date date_complete);

		
		
///////////////////////////////////// Travailleurs actifs		
		//Travailleurs actifs
		@Query("Select count(c.fk_dim_travailleur.cle_dim_travailleur) as nombreTravailleurActif,"
				+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
				+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee and c.fk_dim_motif.motcode=5"
				+ " Group by catLibelle")
		public List<VgTravailleurActif> VueGlobalTravailleurActif(@Param("no_annee")int no_annee);
		
		//Travailleurs actifs/Intervalle de temps
		@Query("Select count(c.fk_dim_travailleur.cle_dim_travailleur) as nombreTravailleurActif,"
				+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
				+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_motif.date_complete between :datedebut AND :datefin and c.fk_dim_motif.motcode=5"
				+ " Group by catLibelle")
		public List<VgTravailleurActif> VueGlobalTravailleurActifInterv(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin);

		
		//Travailleurs actifs/date complète
		@Query("Select count(c.fk_dim_travailleur.cle_dim_travailleur) as nombreTravailleurActif,"
				+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
				+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_motif.date_complete=:date_complete and c.fk_dim_motif.motcode=5"
				+ " Group by catLibelle")
		public List<VgTravailleurActif> VueGlobalTravailleurActifDate(@Param("date_complete")Date date_complete);

	
		
//////////////////////////////////////Travailleur Retraités	
		//travailleurs retraités
		@Query("Select sum(c.nombre_travailleur_retraite) as nombreTravailleurRetraite,"
		+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
		+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee"
		+ " Group by catLibelle")
		public List<VgTravailleurRetraite> VueGlobalTravailleurRetraite(@Param("no_annee")int no_annee);
		
		//travailleurs retraités/Intervalle de temps
		@Query("Select sum(c.nombre_travailleur_retraite) as nombreTravailleurRetraite,"
		+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
		+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_motif.date_complete between :datedebut AND :datefin"
		+ " Group by catLibelle")
		public List<VgTravailleurRetraite> VueGlobalTravailleurRetraiteInterv(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin);
		
		
		//travailleurs retraités/date complète
		@Query("Select sum(c.nombre_travailleur_retraite) as nombreTravailleurRetraite,"
		+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
		+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_motif.date_complete=:date_complete"
		+ " Group by catLibelle")
		public List<VgTravailleurRetraite> VueGlobalTravailleurRetraiteDate(@Param("date_complete")Date date_complete);



//////////////////////////////////////Travailleur Décedés	
		//travailleurs décedés
		@Query("Select sum(c.nombre_travailleur_decede) as nombreTravailleurDecede,"
		+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
		+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee"
		+ " Group by catLibelle")
		public List<VgTravailleurDecede> VueGlobalTravailleurDecede(@Param("no_annee")int no_annee);
		
		//travailleurs décedés/Intervalle de temps
		@Query("Select sum(c.nombre_travailleur_decede) as nombreTravailleurDecede,"
		+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
		+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_motif.date_complete between :datedebut AND :datefin"
		+ " Group by catLibelle")
		public List<VgTravailleurDecede> VueGlobalTravailleurDecedeInterv(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin);
		
		
		//travailleurs décedés/date complète
		@Query("Select sum(c.nombre_travailleur_decede) as nombreTravailleurDecede,"
		+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
		+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_motif.date_complete=:date_complete"
		+ " Group by catLibelle")
		public List<VgTravailleurDecede> VueGlobalTravailleurDecedeDate(@Param("date_complete")Date date_complete);


//////////////////////////////////////Travailleur Autres Motifs	
		//travailleurs Autres motifs
		@Query("Select sum(c.nombre_travailleur_autre_motif) as nombreTravailleurAutreMotif,"
		+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
		+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee"
		+ " Group by catLibelle")
		public List<VgTravailleurAutreMotifs> VueGlobalTravailleurAutreMotif(@Param("no_annee")int no_annee);
		
		//travailleurs autres motifs/Intervalle de temps
		@Query("Select sum(c.nombre_travailleur_autre_motif) as nombreTravailleurAutreMotif,"
		+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
		+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_motif.date_complete between :datedebut AND :datefin"
		+ " Group by catLibelle")
		public List<VgTravailleurAutreMotifs> VueGlobalTravailleurAutreMotifInterv(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin);
		
		
		//travailleurs autres motifs/date complète
		@Query("Select sum(c.nombre_travailleur_autre_motif) as nombreTravailleurAutreMotif,"
		+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
		+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_motif.date_complete=:date_complete"
		+ " Group by catLibelle")
		public List<VgTravailleurAutreMotifs> VueGlobalTravailleurAutreMotifDate(@Param("date_complete")Date date_complete);


//////////////////////////////////////Total Travailleur
		//Nombre travailleur/
		@Query("Select sum(c.fk_dim_travailleur.cle_dim_travailleur) as nombreTravailleur,"
				+ " c.fk_dim_cat_activite.cat_libelle as catLibelle,"
				+ " c.fk_date_motif.no_annee as noAnnee"
				+ " From Ima_fait_travailleur_transactionnel c Where c.fk_date_motif.no_annee=:no_annee"
				+ " Group by catLibelle")
				public List<VueGlobalTotalTravailleur> VueGlobalTotalTravailleur(@Param("no_annee")int no_annee);
				
		
		//Nombre travailleur/Intervalle
		
		@Query("Select count(c.fk_dim_travailleur.cle_dim_travailleur) as nombreTravailleur,"
				+ " c.fk_dim_cat_activite.cat_libelle as catLibelle,"
				+ " c.fk_date_motif.no_annee as noAnnee"
				+ " From Ima_fait_travailleur_transactionnel c"
				+ " Where c.fk_date_motif.date_complete between :datedebut AND :datefin "
				+ " Group by noAnnee, catLibelle"
				+ " Order by noAnnee DESC")					
		public List<VueGlobalTotalTravailleur> VueGlobalTotalTravailleurInterv(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin);
	
		
		//Nombre travailleur/date complete
		@Query("Select count(c.fk_dim_travailleur.cle_dim_travailleur) as nombreTravailleur,"
				+ " c.fk_dim_cat_activite.cat_libelle as catLibelle,"
				+ " c.fk_date_motif.no_annee as noAnnee"
				+ " From Ima_fait_travailleur_transactionnel c"
				+ " Where c.fk_date_motif.date_complete=:date_complete "
				+ " Group by noAnnee, catLibelle"
				+ " Order by noAnnee DESC")					
		public List<VueGlobalTotalTravailleur>VueGlobalTotalTravailleurDate(@Param("date_complete")Date date_complete);
	
	
		

	

	//************************************************* TABLEAU 5 *********************************************//
	
	
	@Query("Select sum(c.nombre_travailleur_nouvelle_immatriculation) as nouvelleImmatriculation,"
			+ " c.fk_dim_cat_activite.cat_code as codeActivite,"
			+ " c.fk_dim_cat_activite.cat_libelle as catLibelle,"
			+ " c.fk_date_immatriculation.no_mois as noMois"
			+ " From Ima_fait_travailleur_transactionnel c"
			+ " Where c.fk_date_immatriculation.no_annee=:no_annee"
			+ " Group by noMois, codeActivite,catLibelle"
			+ " Order by noMois"
			)
	public List<Tableau5> Tableau5(@Param("no_annee")int no_annee);
	
	//************************************************  TABLEAU 6   ******************************************//
	
    //Requête tableau 6

			@Query("SELECT count(c.fk_dim_travailleur.cle_dim_travailleur) as effectifActif,"
			   + " c.fk_dim_cat_activite.cat_code as codeActivite,"
			   + " c.fk_dim_cat_activite.cat_libelle as catLibelle"
			   +" From Ima_fait_travailleur_transactionnel c"
			   + " where c.fk_date_motif.date_complete <=:periode and c.fk_dim_motif.motcode=5" 
			   + " group by codeActivite,catLibelle"
			   + " order by codeActivite asc")
			public List<Tableau6_1> Tableau6effectifDFp(@Param("periode")Date periode);
			
			@Query("Select sum(c.nombre_travailleur_nouvelle_immatriculation) as nouvelleImmatriculation,"
					+ " c.fk_dim_cat_activite.cat_code as codeActivite,"
					+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
					+ " From Ima_fait_travailleur_transactionnel c"
					+ " Where c.fk_date_immatriculation.no_annee=:no_annee"
					+ " Group by codeActivite,catLibelle")
			public List<Tableau6_2> Tableau6MotifNouvelleImma(@Param("no_annee")int no_annee);
			
			
			@Query("Select"
					+ " sum(c.nombre_travailleur_retraite) as nombreRetraite,"
					+ " sum(c.nombre_travailleur_decede) as nombreDecede,"
					+ " sum(c.nombre_travailleur_autre_motif) as nombreAutreMotif,"
					+ " c.fk_dim_cat_activite.cat_code as codeActivite"
					+ " From Ima_fait_travailleur_transactionnel c"
					+ " Where c.fk_date_motif.no_annee=:no_annee"
					+ " Group by codeActivite")
			public List<Tableau6_2> Tableau6Motif(@Param("no_annee")int no_annee);
			
			
		
	
//************************************************  TABLEAU 7   ******************************************//
			
		    //Requête tableau 7

					@Query("SELECT count(c.fk_dim_travailleur.cle_dim_travailleur) as effectifActif,"
					   + " c.fk_dim_secactivite.seccode as secCode,"
					   + " c.fk_dim_secactivite.seclibel as secLibelle"
					   +" From Ima_fait_travailleur_transactionnel c"
					   + " where c.fk_date_motif.date_complete <=:periode and c.fk_dim_motif.motcode=5" 
					   + " group by secCode,secLibelle"
					   + " order by secCode asc")
					public List<Tableau7_1> Tableau7effectifDFp(@Param("periode")Date periode);
					
					@Query("Select sum(c.nombre_travailleur_nouvelle_immatriculation) as nouvelleImmatriculation,"
							+ " c.fk_dim_secactivite.seccode as secCode,"
							 + " c.fk_dim_secactivite.seclibel as secLibelle"
							+ " From Ima_fait_travailleur_transactionnel c"
							+ " Where c.fk_date_immatriculation.no_annee=:no_annee"
							+ " Group by secCode,secLibelle")
					public List<Tableau7_2> Tableau7MotifNouvelleImma(@Param("no_annee")int no_annee);
					
					
					@Query("Select"
							+ " sum(c.nombre_travailleur_retraite) as nombreRetraite,"
							+"  sum(c.nombre_travailleur_decede) as nombreDecede,"
							+"  sum(c.nombre_travailleur_autre_motif) as nombreAutreMotif,"
							+ " c.fk_dim_secactivite.seccode as secCode"
							+ " From Ima_fait_travailleur_transactionnel c"
							+ " Where c.fk_date_motif.no_annee=:no_annee "
							+ " Group by secCode")
					public List<Tableau7_2> Tableau7Motif(@Param("no_annee")int no_annee);			
					
//**************************************************  TABLEAU 8  ********************************************//
 
//Requête tableau8					

	@Query("Select distinct(count(c.fk_dim_travailleur.trv_numero_cnps)) as nombreTravailleur,"
			+ "c.fk_date_naissance.no_annee as dateNaissance,"
			+ " c.fk_dim_sexe.sex_code as sexCode,"
			+ " c.fk_dim_sexe.sex_libelle as sexLibelle"
			+ " From Ima_fait_travailleur_transactionnel c"
			+ " Where c.fk_date_immatriculation.cle_date !=-4 and c.fk_date_immatriculation.no_annee=:no_annee"
			+ " Group by dateNaissance,sexCode,sexLibelle" )
	public List<Tableau8> Tableau8Data(@Param("no_annee")int no_annee);
	
	
	//**************************************************  TABLEAU 10  ********************************************//
	 
	//Requête tableau10
	@Query("Select distinct(count(c.fk_dim_travailleur.trv_numero_cnps)) as nombreTravailleur,"
			+ " c.fk_date_immatriculation.no_annee as dateImma,"
			+ " c.fk_dim_sexe.sex_code as sexCode,"
			+ " c.fk_dim_sexe.sex_libelle as sexLibelle,"
			+ " c.fk_dim_cat_activite.cat_code as codeActivite,"
			+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
			+ " From Ima_fait_travailleur_transactionnel c"
			+ " Where c.fk_date_immatriculation.cle_date !=-4 and c.fk_date_immatriculation.no_annee=:no_annee"
			+ " Group by dateImma,sexCode,sexLibelle,codeActivite,catLibelle" )
	public List<Tableau10> Tableau10Data(@Param("no_annee")int no_annee);
	
	
}
