package com.osis.cipres.immatriculation.repositories;

import java.sql.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.osis.cipres.immatriculation.jsonForm.Tableau1;
import com.osis.cipres.immatriculation.jsonForm.Tableau1_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau2_1;
import com.osis.cipres.immatriculation.jsonForm.Tableau2_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau2_3;
import com.osis.cipres.immatriculation.jsonForm.Tableau2_NI;
import com.osis.cipres.immatriculation.jsonForm.Tableau3_1;
import com.osis.cipres.immatriculation.jsonForm.Tableau3_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau3_3;
import com.osis.cipres.immatriculation.jsonForm.Tableau4;
import com.osis.cipres.immatriculation.jsonForm.VgActif;
import com.osis.cipres.immatriculation.jsonForm.VgRadie;
import com.osis.cipres.immatriculation.jsonForm.VgReactive;
import com.osis.cipres.immatriculation.jsonForm.VgSuspendus;
import com.osis.cipres.immatriculation.tables.Ima_fait_employeur_mensuel;




public interface FaitEmployeurMensuelRepository extends JpaRepository<Ima_fait_employeur_mensuel, Long>{
	
	//************************************************  REQUETE POUR VUE GLOBALE EMPLOYEUR ****************************************//
	

									//Nouvelles immatriculations
	 //Nouvelle immatriculation/
	@Query("Select sum(c.nombre_nouvel_immatriculation) as nouvelleImmatriculation,"
			+ "	c.fk_dim_cat_activite.cat_libelle as catLibelle"
			+ " From Ima_fait_employeur_mensuel c Where c.fk_date_motif.no_annee=:no_annee"
			+ " group by catLibelle"
			)
	public List<Tableau2_NI> vueGlobalNI(@Param("no_annee")int no_annee);
	
	
	// Nouvelle immatriculation/ Intervalle de temps
	@Query("Select sum(c.nombre_nouvel_immatriculation) as nouvelleImmatriculation,"
			+ "	c.fk_dim_cat_activite.cat_libelle as catLibelle"
			+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.date_complete between :datedebut AND :datefin"
			+ " group by catLibelle"
			)
	public List<Tableau2_NI> vueGlobalNInterv(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin);
	
	
	// Nouvelle immatriculation/ Date complète

	@Query("Select sum(c.nombre_nouvel_immatriculation) as nouvelleImmatriculation,"
			+ "	c.fk_dim_cat_activite.cat_libelle as catLibelle"
			+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.date_complete=:date_complete"
			+ " group by catLibelle"
			)
	public List<Tableau2_NI> vueGlobalNIDate(@Param("date_complete")Date date_complete);
	
	
								//actifs
	
	//employeurs actifs
	@Query("Select sum(c.nombre_employeur_actif) as nombreEmployeurActif,"
			+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
			+ " From Ima_fait_employeur_mensuel c Where c.fk_date_motif.no_annee=:no_annee"
			+ " Group by catLibelle")
	public List<VgActif> EmpActif(@Param("no_annee")int no_annee);
	
	//employeurs actifs/Intervalle de temps
	@Query("Select sum(c.nombre_employeur_actif) as nombreEmployeurActif,"
			+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
			+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.date_complete between :datedebut AND :datefin"
			+ " Group by catLibelle")
	public List<VgActif> EmpActifInterv(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin);

	
	//employeurs actifs/date complète
		@Query("Select sum(c.nombre_employeur_actif) as nombreEmployeurActif,"
				+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
				+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.date_complete=:date_complete"
				+ " Group by catLibelle")
		public List<VgActif> EmpActifDate(@Param("date_complete")Date date_complete);

	
							//reactives
		
	//employeurs reactive
	@Query("Select sum(c.nombre_employeur_reactive) as nombreEmployeurReactive,"
			+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
			+ " From Ima_fait_employeur_mensuel c Where c.fk_date_motif.no_annee=:no_annee"
			+ " Group by catLibelle")
	public List<VgReactive> EmpReactive(@Param("no_annee")int no_annee);
	
	//employeurs reactive/Intervalle de temps
		@Query("Select sum(c.nombre_employeur_reactive) as nombreEmployeurReactive,"
				+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
				+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.date_complete between :datedebut AND :datefin"
				+ " Group by catLibelle")
		public List<VgReactive> EmpReactiveInterv(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin);
			
		
	//employeurs reactive/Date complète
		@Query("Select sum(c.nombre_employeur_reactive) as nombreEmployeurReactive,"
				+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
				+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.date_complete=:date_complete"
				+ " Group by catLibelle")
		public List<VgReactive> EmpReactiveDate(@Param("date_complete")Date date_complete);
		
		
		
							//suspendus
	
	//employeurs suspendu
	@Query("Select sum(c.nombre_employeur_suspendu) as nombreEmployeurSuspendu,"
			+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
			+ " From Ima_fait_employeur_mensuel c Where c.fk_date_motif.no_annee=:no_annee"
			+ " Group by catLibelle")
	public List<VgSuspendus> EmpSuspendus(@Param("no_annee")int no_annee);
	
	//employeurs suspendu/intervalle de temps
	@Query("Select sum(c.nombre_employeur_suspendu) as nombreEmployeurSuspendu,"
			+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
			+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.date_complete between :datedebut AND :datefin"
			+ " Group by catLibelle")
	public List<VgSuspendus> EmpSuspendusInterv(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin);
	
	//employeurs suspendu/date complete
	@Query("Select sum(c.nombre_employeur_suspendu) as nombreEmployeurSuspendu,"
			+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
			+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.date_complete=:date_complete"
			+ " Group by catLibelle")
	public List<VgSuspendus> EmpSuspendusDate(@Param("date_complete")Date date_complete);
	
	
				
									//radie
	
	//employeurs radie
	@Query("Select sum(c.nombre_employeur_radie) as nombreEmployeurRadie,"
			+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
			+ " From Ima_fait_employeur_mensuel c Where c.fk_date_motif.no_annee=:no_annee"
			+ " Group by catLibelle")
	public List<VgRadie> EmpRadie(@Param("no_annee")int no_annee);
	
	
	//employeurs radie/Intervalle de temps
	@Query("Select sum(c.nombre_employeur_radie) as nombreEmployeurRadie,"
			+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
			+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.date_complete between :datedebut AND :datefin"
			+ " Group by catLibelle")
	public List<VgRadie> EmpRadieInterv(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin);

	
	//employeurs radie/date complète
	@Query("Select sum(c.nombre_employeur_radie) as nombreEmployeurRadie,"
			+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
			+ " From Ima_fait_employeur_transactionnel c Where c.fk_date_motif.date_complete=:date_complete"
			+ " Group by catLibelle")
	public List<VgRadie> EmpRadieDate(@Param("date_complete")Date date_complete);

	
									//Total employeurs
	
		//Nombre d'employeur/Intervalle
		
		@Query("Select count(c.fk_dim_employeur.cle_dim_employeur) as nombreEmployeur,"
				+ " c.fk_dim_cat_activite.cat_libelle as catLibelle,"
				+ " c.fk_date_motif.no_annee as noAnnee"
				+ " From Ima_fait_employeur_transactionnel c"
				+ " Where c.fk_date_motif.date_complete between :datedebut AND :datefin and c.fk_date_motif.cle_date !=-4 "
				+ " Group by noAnnee, catLibelle"
				+ " Order by noAnnee DESC")					
		public List<Tableau4> Tableau4AnneeInterv(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin);
	
		
		//Nombre d'employeur/date complete
		@Query("Select count(c.fk_dim_employeur.cle_dim_employeur) as nombreEmployeur,"
				+ " c.fk_dim_cat_activite.cat_libelle as catLibelle,"
				+ " c.fk_date_motif.no_annee as noAnnee"
				+ " From Ima_fait_employeur_transactionnel c"
				+ " Where c.fk_date_motif.date_complete=:date_complete "
				+ " Group by noAnnee, catLibelle"
				+ " Order by noAnnee DESC")					
		public List<Tableau4> TotalEmpDate(@Param("date_complete")Date date_complete);
	
	
	
	//************************************************  TABLEAU 1   ******************************************//
   //Requêtes pour les données du tableau 1
	@Query("Select sum(c.nombre_nouvel_immatriculation) as nouvelleImmatriculation,"
			+ " c.fk_dim_cat_activite.cat_libelle as catLibelle,"
			+ " c.fk_dim_taille_employeur.tai_libelle as taiLibelle,"
			+ " c.fk_date_motif.no_mois as noMois"
			+ " From Ima_fait_employeur_mensuel c"
			+ " Where c.fk_date_motif.no_annee=:no_annee"
			+ " and  c.fk_dim_cat_activite.cle_dim_cat_activite in (1,2)"
			+ " Group by noMois, catLibelle, taiLibelle ")
	public List<Tableau1> Tableau1Part1(@Param("no_annee")int no_annee);
	
	@Query("Select sum(c.nombre_nouvel_immatriculation) as nouvelleImmatriculation,"
			+ " c.fk_dim_cat_activite.cat_libelle as catLibelle,"
			+ " c.fk_date_motif.no_mois as noMois"
			+ " From Ima_fait_employeur_mensuel c"
			+ " Where c.fk_date_motif.no_annee=:no_annee"
			+ " Group by noMois, catLibelle"
			+ " Order by noMois"
			+ ""
			+ ""
			)
	public List<Tableau1_2> Tableau1Part2(@Param("no_annee")int no_annee);
	
	
	//************************************************  TABLEAU 2   ******************************************//
	

	//Requêtes pour tableau 2
	
	@Query("SELECT count(c.fk_dim_employeur.cle_dim_employeur) as effectifActifDp,"
	   + " c.fk_dim_cat_activite.cat_libelle as catLibelle"
	   +" From Ima_fait_employeur_transactionnel c"
	   + " where c.fk_dim_employeur.emp_date_dernier_motif <=:periode and c.fk_dim_employeur.emp_dernier_motif=1" 
	   + " group by catLibelle"
	   + " order by catLibelle asc")
	public List<Tableau2_1> Tableau2effectifDp(@Param("periode")Date periode);
	
	
	@Query("Select sum(c.nombre_nouvel_immatriculation) as nouvelleImmatriculation,"
			+ " sum(c.nombre_employeur_suspendu) as nombreSuspendu,"
			+"  sum(c.nombre_employeur_reactive) as nombreReactive,"
			+"  sum(c.nombre_employeur_radie) as nombreRadie,"
			+ " c.fk_dim_cat_activite.cat_libelle as catLibelle"
			+ " From Ima_fait_employeur_mensuel c"
			+ " Where c.fk_date_motif.no_annee=:no_annee"
			+ " Group by catLibelle")
	public List<Tableau2_2> Tableau2Motif(@Param("no_annee")int no_annee);
	
	
	@Query("SELECT count(c.fk_dim_employeur.cle_dim_employeur) as effectifActifFp,"
			   + " c.fk_dim_cat_activite.cat_libelle as catLibelle"
			   +" From Ima_fait_employeur_transactionnel c"
			   + " where c.fk_dim_employeur.emp_date_dernier_motif <=:periode and c.fk_dim_employeur.emp_dernier_motif=1" 
			   + " group by catLibelle"
			   + " order by catLibelle asc")
			public List<Tableau2_3> Tableau2effectifFp(@Param("periode")Date periode);
			
//************************************************  TABLEAU 3   ******************************************//
			
      //Requête tableau 3

			@Query("SELECT count(c.fk_dim_employeur.cle_dim_employeur) as effectifActifDp,"
			   + " c.fk_dim_secactivite.seclibel as secLibelle"
			   +" From Ima_fait_employeur_transactionnel c"
			   + " where c.fk_dim_employeur.emp_date_dernier_motif <=:periode and c.fk_dim_employeur.emp_dernier_motif=1" 
			   + " group by secLibelle"
			   + " order by secLibelle asc")
			public List<Tableau3_1> Tableau3effectifDp(@Param("periode")Date periode);
			
			@Query("Select sum(c.nombre_nouvel_immatriculation) as nouvelleImmatriculation,"
					+ " sum(c.nombre_employeur_suspendu) as nombreSuspendu,"
					+"  sum(c.nombre_employeur_reactive) as nombreReactive,"
					+"  sum(c.nombre_employeur_radie) as nombreRadie,"
					+ " c.fk_dim_secactivite.seclibel as secLibelle"
					+ " From Ima_fait_employeur_mensuel c"
					+ " Where c.fk_date_motif.no_annee=:no_annee or c.fk_date_motif.no_annee =:no_annee"
					+ " Group by secLibelle")
			public List<Tableau3_2> Tableau3Motif(@Param("no_annee")int no_annee);
			
			@Query("SELECT count(c.fk_dim_employeur.cle_dim_employeur) as effectifActifFp,"
					   + " c.fk_dim_secactivite.seclibel as secLibelle"
					   +" From Ima_fait_employeur_transactionnel c"
					   + " where c.fk_dim_employeur.emp_date_dernier_motif <=:periode and c.fk_dim_employeur.emp_dernier_motif=1" 
					   + " group by secLibelle"
					   + " order by secLibelle asc")
					public List<Tableau3_3> Tableau3effectifFp(@Param("periode")Date periode);	
					
			
//************************************************  TABLEAU 4   ******************************************//
					
				//Requête pour le tableau 4
					
					@Query("Select count(c.fk_dim_employeur.cle_dim_employeur) as nombreEmployeur,"
							+ " c.fk_dim_cat_activite.cat_libelle as catLibelle,"
							+ " c.fk_date_motif.no_annee as noAnnee"
							+ " From Ima_fait_employeur_transactionnel c"
							+ " Where c.fk_date_motif.no_annee=:no_annee and c.fk_date_motif.cle_date !=-4 "
							+ " Group by noAnnee, catLibelle"
							+ " Order by noAnnee DESC")					
					public List<Tableau4> Tableau4(@Param("no_annee")int no_annee);

					

}
