package com.osis.cipres.immatriculation.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name="Ima_fait_travailleur_mensuel",schema="DATAMART")
public class Ima_fait_travailleur_mensuel {
	@Id
	private Long id_travailleur_mensuel;
	
	@ManyToOne
	@JoinColumn(name="cle_categorie_employeur",referencedColumnName="cle_categorie_employeur")
	private Ima_dim_categorie_employeur cle_categorie_employeur; 
	
	@ManyToOne
	@JoinColumn(name="cle_branche_activite",referencedColumnName="cle_branche_activite")
	private Ima_dim_branche_activite cle_branche_activite;
	
	@ManyToOne
	@JoinColumn(name="cle_mois",referencedColumnName="cle_mois")
	private Ima_dim_mois cle_mois;
	
	@ManyToOne
	@JoinColumn(name="cle_groupe_age",referencedColumnName="cle_groupe_age")
	private Ima_dim_groupe_age cle_groupe_age;
	
	@ManyToOne
	@JoinColumn(name="cle_sexe",referencedColumnName="cle_sexe")
	private Ima_dim_sexe cle_sexe;
	
	@ManyToOne
	@JoinColumn(name="cle_pays",referencedColumnName="cle_pays")
	private Ima_dim_pays cle_pays;
	
	private int nombre_travailleur;
	private int nombre_travailleur_nouvelle_immatriculation;
	private Double salaire_plafonne;
	private Double salaire_non_plafonne;
	private int nombre_travailleur_retraite;
	private int nombre_travailleur_decede;
	private int nombre_travailleur_autre_motif;
	public Long getId_travailleur_mensuel() {
		return id_travailleur_mensuel;
	}
	public void setId_travailleur_mensuel(Long id_travailleur_mensuel) {
		this.id_travailleur_mensuel = id_travailleur_mensuel;
	}
	public Ima_dim_categorie_employeur getCle_categorie_employeur() {
		return cle_categorie_employeur;
	}
	public void setCle_categorie_employeur(Ima_dim_categorie_employeur cle_categorie_employeur) {
		this.cle_categorie_employeur = cle_categorie_employeur;
	}
	public Ima_dim_branche_activite getCle_branche_activite() {
		return cle_branche_activite;
	}
	public void setCle_branche_activite(Ima_dim_branche_activite cle_branche_activite) {
		this.cle_branche_activite = cle_branche_activite;
	}
	public Ima_dim_mois getCle_mois() {
		return cle_mois;
	}
	public void setCle_mois(Ima_dim_mois cle_mois) {
		this.cle_mois = cle_mois;
	}
	public Ima_dim_groupe_age getCle_groupe_age() {
		return cle_groupe_age;
	}
	public void setCle_groupe_age(Ima_dim_groupe_age cle_groupe_age) {
		this.cle_groupe_age = cle_groupe_age;
	}
	public Ima_dim_sexe getCle_sexe() {
		return cle_sexe;
	}
	public void setCle_sexe(Ima_dim_sexe cle_sexe) {
		this.cle_sexe = cle_sexe;
	}
	public Ima_dim_pays getCle_pays() {
		return cle_pays;
	}
	public void setCle_pays(Ima_dim_pays cle_pays) {
		this.cle_pays = cle_pays;
	}
	public int getNombre_travailleur() {
		return nombre_travailleur;
	}
	public void setNombre_travailleur(int nombre_travailleur) {
		this.nombre_travailleur = nombre_travailleur;
	}
	public int getNombre_travailleur_nouvelle_immatriculation() {
		return nombre_travailleur_nouvelle_immatriculation;
	}
	public void setNombre_travailleur_nouvelle_immatriculation(int nombre_travailleur_nouvelle_immatriculation) {
		this.nombre_travailleur_nouvelle_immatriculation = nombre_travailleur_nouvelle_immatriculation;
	}
	public Double getSalaire_plafonne() {
		return salaire_plafonne;
	}
	public void setSalaire_plafonne(Double salaire_plafonne) {
		this.salaire_plafonne = salaire_plafonne;
	}
	public Double getSalaire_non_plafonne() {
		return salaire_non_plafonne;
	}
	public void setSalaire_non_plafonne(Double salaire_non_plafonne) {
		this.salaire_non_plafonne = salaire_non_plafonne;
	}
	public int getNombre_travailleur_retraite() {
		return nombre_travailleur_retraite;
	}
	public void setNombre_travailleur_retraite(int nombre_travailleur_retraite) {
		this.nombre_travailleur_retraite = nombre_travailleur_retraite;
	}
	public int getNombre_travailleur_decede() {
		return nombre_travailleur_decede;
	}
	public void setNombre_travailleur_decede(int nombre_travailleur_decede) {
		this.nombre_travailleur_decede = nombre_travailleur_decede;
	}
	public int getNombre_travailleur_autre_motif() {
		return nombre_travailleur_autre_motif;
	}
	public void setNombre_travailleur_autre_motif(int nombre_travailleur_autre_motif) {
		this.nombre_travailleur_autre_motif = nombre_travailleur_autre_motif;
	}
	public Ima_fait_travailleur_mensuel(Long id_travailleur_mensuel,
			Ima_dim_categorie_employeur cle_categorie_employeur, Ima_dim_branche_activite cle_branche_activite,
			Ima_dim_mois cle_mois, Ima_dim_groupe_age cle_groupe_age, Ima_dim_sexe cle_sexe, Ima_dim_pays cle_pays,
			int nombre_travailleur, int nombre_travailleur_nouvelle_immatriculation, Double salaire_plafonne,
			Double salaire_non_plafonne, int nombre_travailleur_retraite, int nombre_travailleur_decede,
			int nombre_travailleur_autre_motif) {
		super();
		this.id_travailleur_mensuel = id_travailleur_mensuel;
		this.cle_categorie_employeur = cle_categorie_employeur;
		this.cle_branche_activite = cle_branche_activite;
		this.cle_mois = cle_mois;
		this.cle_groupe_age = cle_groupe_age;
		this.cle_sexe = cle_sexe;
		this.cle_pays = cle_pays;
		this.nombre_travailleur = nombre_travailleur;
		this.nombre_travailleur_nouvelle_immatriculation = nombre_travailleur_nouvelle_immatriculation;
		this.salaire_plafonne = salaire_plafonne;
		this.salaire_non_plafonne = salaire_non_plafonne;
		this.nombre_travailleur_retraite = nombre_travailleur_retraite;
		this.nombre_travailleur_decede = nombre_travailleur_decede;
		this.nombre_travailleur_autre_motif = nombre_travailleur_autre_motif;
	}
	public Ima_fait_travailleur_mensuel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
