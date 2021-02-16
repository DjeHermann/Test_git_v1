package com.osis.cipres.immatriculation.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dat_ima_fait_mensuel_employeur",schema="data_marts")
public class Ima_fait_employeur_mensuel {
	@Id
	private Long cle_fait_mensuel_employeur;
	
	@ManyToOne
	@JoinColumn(name="fk_dim_cat_activite",referencedColumnName="cle_dim_cat_activite")
	private Ima_dim_categorie_employeur fk_dim_cat_activite; 
	
	@ManyToOne
	@JoinColumn(name="fk_dim_taille_employeur",referencedColumnName="cle_dim_taille_employeur")
	private Ima_dim_taille_employeur fk_dim_taille_employeur;
	
	@ManyToOne
	@JoinColumn(name="fk_dim_secactivite",referencedColumnName="cle_dim_secactivite")
	private Ima_dim_branche_activite fk_dim_secactivite;
	
	
	@ManyToOne
	@JoinColumn(name="fk_date_motif",referencedColumnName="cle_mois")
	private Ima_dim_mois fk_date_motif;
	

	@ManyToOne
	@JoinColumn(name="fk_dim_pays",referencedColumnName="cle_dim_pays")
	private Ima_dim_pays fk_dim_pays;
	
	private int nombre_nouvel_immatriculation;
	private int nombre_employeur_actif;
	private int nombre_employeur_suspendu;
	private int nombre_employeur_reactive;
	private int nombre_employeur_radie;
	public Long getCle_fait_mensuel_employeur() {
		return cle_fait_mensuel_employeur;
	} 
	public void setCle_fait_mensuel_employeur(Long cle_fait_mensuel_employeur) {
		this.cle_fait_mensuel_employeur = cle_fait_mensuel_employeur;
	}
	public Ima_dim_categorie_employeur getFk_dim_cat_activite() {
		return fk_dim_cat_activite;
	}
	public void setFk_dim_cat_activite(Ima_dim_categorie_employeur fk_dim_cat_activite) {
		this.fk_dim_cat_activite = fk_dim_cat_activite;
	}
	public Ima_dim_taille_employeur getFk_dim_taille_employeur() {
		return fk_dim_taille_employeur;
	}
	public void setFk_dim_taille_employeur(Ima_dim_taille_employeur fk_dim_taille_employeur) {
		this.fk_dim_taille_employeur = fk_dim_taille_employeur;
	}
	public Ima_dim_branche_activite getFk_dim_secactivite() {
		return fk_dim_secactivite;
	}
	public void setFk_dim_secactivite(Ima_dim_branche_activite fk_dim_secactivite) {
		this.fk_dim_secactivite = fk_dim_secactivite;
	}
	
	public Ima_dim_mois getFk_date_motif() {
		return fk_date_motif;
	}
	public void setFk_date_motif(Ima_dim_mois fk_date_motif) {
		this.fk_date_motif = fk_date_motif;
	}
	public Ima_dim_pays getFk_dim_pays() {
		return fk_dim_pays;
	}
	public void setFk_dim_pays(Ima_dim_pays fk_dim_pays) {
		this.fk_dim_pays = fk_dim_pays;
	}
	public int getnombre_nouvel_immatriculation() {
		return nombre_nouvel_immatriculation;
	}
	public void setnombre_nouvel_immatriculation(int nombre_nouvel_immatriculation) {
		this.nombre_nouvel_immatriculation = nombre_nouvel_immatriculation;
	}
	public int getNombre_employeur_actif() {
		return nombre_employeur_actif;
	}
	public void setNombre_employeur_actif(int nombre_employeur_actif) {
		this.nombre_employeur_actif = nombre_employeur_actif;
	}
	public int getNombre_employeur_suspendu() {
		return nombre_employeur_suspendu;
	}
	public void setNombre_employeur_suspendu(int nombre_employeur_suspendu) {
		this.nombre_employeur_suspendu = nombre_employeur_suspendu;
	}
	public int getNombre_employeur_reactive() {
		return nombre_employeur_reactive;
	}
	public void setNombre_employeur_reactive(int nombre_employeur_reactive) {
		this.nombre_employeur_reactive = nombre_employeur_reactive;
	}
	public int getNombre_employeur_radie() {
		return nombre_employeur_radie;
	}
	public void setNombre_employeur_radie(int nombre_employeur_radie) {
		this.nombre_employeur_radie = nombre_employeur_radie;
	}
	public Ima_fait_employeur_mensuel(Long cle_fait_mensuel_employeur, Ima_dim_categorie_employeur fk_dim_cat_activite,
			Ima_dim_taille_employeur fk_dim_taille_employeur, Ima_dim_branche_activite fk_dim_secactivite,
			Ima_dim_mois fk_date_immatriculation, Ima_dim_mois fk_date_motif, Ima_dim_pays fk_dim_pays,
			int nombre_nouvel_immatriculation, int nombre_employeur_actif, int nombre_employeur_suspendu,
			int nombre_employeur_reactive, int nombre_employeur_radie) {
		super();
		this.cle_fait_mensuel_employeur = cle_fait_mensuel_employeur;
		this.fk_dim_cat_activite = fk_dim_cat_activite;
		this.fk_dim_taille_employeur = fk_dim_taille_employeur;
		this.fk_dim_secactivite = fk_dim_secactivite;
		this.fk_date_motif = fk_date_motif;
		this.fk_dim_pays = fk_dim_pays;
		this.nombre_nouvel_immatriculation = nombre_nouvel_immatriculation;
		this.nombre_employeur_actif = nombre_employeur_actif;
		this.nombre_employeur_suspendu = nombre_employeur_suspendu;
		this.nombre_employeur_reactive = nombre_employeur_reactive;
		this.nombre_employeur_radie = nombre_employeur_radie;
	}
	public Ima_fait_employeur_mensuel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
