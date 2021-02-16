package com.osis.cipres.immatriculation.jsonForm;

import java.sql.Date;

import com.osis.cipres.immatriculation.tables.Ima_dim_employeur;

public interface Tableau1Details {
	
    int getNouvelleImmatriculation();
	String getCatLibelle();
	String getTaiLibelle();
	String getSecteurLibelle();
	String getDateImmatriculation();
	String getEmployeur();

}
