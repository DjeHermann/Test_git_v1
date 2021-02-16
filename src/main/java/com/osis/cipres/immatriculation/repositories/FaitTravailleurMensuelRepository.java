package com.osis.cipres.immatriculation.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.osis.cipres.immatriculation.jsonForm.Tableau2_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau2_3;
import com.osis.cipres.immatriculation.jsonForm.Tableau5;
import com.osis.cipres.immatriculation.jsonForm.Tableau6_1;
import com.osis.cipres.immatriculation.jsonForm.Tableau6_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau6_3;
import com.osis.cipres.immatriculation.jsonForm.Tableau7_1;
import com.osis.cipres.immatriculation.jsonForm.Tableau7_2;
import com.osis.cipres.immatriculation.jsonForm.Tableau7_3;
import com.osis.cipres.immatriculation.tables.Ima_fait_travailleur_transactionnel;


public interface FaitTravailleurMensuelRepository extends JpaRepository<Ima_fait_travailleur_transactionnel, Long>{
	
	//************************************************  TABLEAU 5   ******************************************//
	   //Requêtes pour les données du tableau 5
//		@Query("Select sum(c.nbre_travailleur_nouvelle_immatriculation) as nouvelleImmatriculation,"
//				+ " c.cle_dim_cat_activite.cat_libelle as catLibelle,"
//				+ " c.cle_date_immatriculation.no_mois as noMois"
//				+ " From Ima_fait_travailleur_transactionnel c"
//				+ " Where c.cle_date_immatriculation.no_annee=:no_annee and c.cle_date_immatriculation.cle_mois !=-4 "
//				+ " Group by noMois, catLibelle")
//		public List<Tableau5> Tableau5(@Param("no_annee")int no_annee);
		
		
//************************************************  TABLEAU 6   ******************************************//
		//Requêtes pour tableau 6
		
//		@Query("SELECT count(c.cle_dim_travailleur) as effectifDp,"
//		   + " c.cle_dim_cat_activite.cat_libelle as catLibelle"
//		   + " From Ima_fait_travailleur_transactionnel c"
//	       + " where c.cle_dim_travailleur.date_autre_motif <=:periode" 
//		   + " group by catLibelle"
//		   + " order by catLibelle asc")
//		public List<Tableau6_1> Tableau6effectifDp(@Param("periode")Date periode);
//		
//		
//		@Query("Select sum(c.nbre_travailleur_nouvelle_immatriculation) as nouvelleImmatriculation,"
//				+ " sum(c.nbre_travailleur_retraite) as nombreRetraite,"
//				+"  sum(c.nbre_travailleur_decede) as nombreDecede,"
//				+"  sum(c.nbre_travailleur_autre_motif) as nombreAutreMotif,"
//				+ " c.cle_dim_cat_activite.cat_libelle as catLibelle"
//				+ " From Ima_fait_travailleur_transactionnel c"
//				+ " Where c.cle_date_immatriculation.no_annee=:no_annee or c.cle_date_motif.no_annee =:no_annee "
//				+ " Group by catLibelle")
//		public List<Tableau6_2> Tableau6Motif(@Param("no_annee")int no_annee);
//		
//		
//		@Query("SELECT count(c.cle_dim_travailleur) as effectifFp,"
//				   + " c.cle_dim_cat_activite.cat_libelle as catLibelle"
//				   + " From Ima_fait_travailleur_transactionnel c"
//				   + " where c.cle_dim_travailleur.date_autre_motif <=:periode" 
//				   + " group by catLibelle"
//				   + " order by catLibelle asc")
//				public List<Tableau6_3> Tableau6effectifFp(@Param("periode")Date periode);
				
				
//************************************************  TABLEAU 7   ******************************************//
//Requêtes pour tableau 7
				
//		@Query("SELECT count(c.cle_dim_travailleur) as effectifDp,"
//				   + " c.cle_dim_secactivite.seclibel as secLibelle"
//				   + " From Ima_fait_travailleur_transactionnel c"
//			       + " where c.cle_dim_travailleur.date_autre_motif <=:periode" 
//				   + " group by secLibelle"
//				   + " order by secLibelle asc")
//				public List<Tableau7_1> Tableau7effectifDp(@Param("periode")Date periode);
//				
//				
//				@Query("Select sum(c.nbre_travailleur_nouvelle_immatriculation) as nouvelleImmatriculation,"
//						+ " sum(c.nbre_travailleur_retraite) as nombreRetraite,"
//						+"  sum(c.nbre_travailleur_decede) as nombreDecede,"
//						+"  sum(c.nbre_travailleur_autre_motif) as nombreAutreMotif,"
//						+ " c.cle_dim_secactivite.seclibel as secLibelle"
//						+ " From Ima_fait_travailleur_transactionnel c"
//						+ " Where c.cle_date_immatriculation.no_annee=:no_annee or c.cle_date_motif.no_annee =:no_annee "
//						+ " Group by secLibelle")
//				public List<Tableau7_2> Tableau7Motif(@Param("no_annee")int no_annee);
//				
//				
//				@Query("SELECT count(c.cle_dim_travailleur) as effectifFp,"
//						   + " c.cle_dim_secactivite.seclibel as secLibelle"
//						   + " From Ima_fait_travailleur_transactionnel c"
//						   + " where c.cle_dim_travailleur.date_autre_motif <=:periode" 
//						   + " group by secLibelle"
//						   + " order by secLibelle asc")
//						public List<Tableau7_3> Tableau7effectifFp(@Param("periode")Date periode);

}
