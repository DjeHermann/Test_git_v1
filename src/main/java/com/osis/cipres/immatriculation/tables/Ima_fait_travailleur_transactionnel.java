package com.osis.cipres.immatriculation.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dat_ima_fait_transactionnel_travailleur",schema="data_marts")
public class Ima_fait_travailleur_transactionnel {
	
	
	@Id
	private Long cle_fait_transactionnel_travailleur;
	
	@ManyToOne
	@JoinColumn(name="fk_dim_secactivite",referencedColumnName="cle_dim_secactivite")
	private Ima_dim_branche_activite fk_dim_secactivite;

	@ManyToOne
	@JoinColumn(name="fk_dim_employeur",referencedColumnName="cle_dim_employeur")
	private Ima_dim_employeur fk_dim_employeur;
	
	@ManyToOne
	@JoinColumn(name="fk_dim_travailleur",referencedColumnName="cle_dim_travailleur")
	private Ima_dim_travailleur fk_dim_travailleur;
	
	@ManyToOne
	@JoinColumn(name="fk_date_motif",referencedColumnName="cle_date")
	private Ima_dim_date fk_date_motif;
	
	@ManyToOne
	@JoinColumn(name="fk_dim_cat_activite",referencedColumnName="cle_dim_cat_activite")
	private Ima_dim_categorie_employeur fk_dim_cat_activite; 
	
	@ManyToOne
	@JoinColumn(name="fk_date_immatriculation",referencedColumnName="cle_date")
	private Ima_dim_date fk_date_immatriculation;
	
	@ManyToOne
	@JoinColumn(name="fk_dim_motif",referencedColumnName="cle_dim_motif")
	private Ima_dim_motif fk_dim_motif;
	
	@ManyToOne
	@JoinColumn(name="fk_dim_sexe",referencedColumnName="cle_dim_sexe")
	private Ima_dim_sexe fk_dim_sexe;
	
	@ManyToOne
	@JoinColumn(name="fk_dim_pays",referencedColumnName="cle_dim_pays")
	private Ima_dim_pays fk_dim_pays;
	
	@ManyToOne
	@JoinColumn(name="fk_date_naissance",referencedColumnName="cle_date")
	private Ima_dim_date fk_date_naissance;

	private Double salaire_plafonne;
	private Double salaire_non_plafonne;
	private int nombre_travailleur_nouvelle_immatriculation;
	private int nombre_travailleur_retraite;
	private int nombre_travailleur_decede;
	private int nombre_travailleur_autre_motif;
	public Long getCle_fait_transactionnel_travailleur() {
		return cle_fait_transactionnel_travailleur;
	}
	public void setCle_fait_transactionnel_travailleur(Long cle_fait_transactionnel_travailleur) {
		this.cle_fait_transactionnel_travailleur = cle_fait_transactionnel_travailleur;
	}
	public Ima_dim_branche_activite getFk_dim_secactivite() {
		return fk_dim_secactivite;
	}
	public void setFk_dim_secactivite(Ima_dim_branche_activite fk_dim_secactivite) {
		this.fk_dim_secactivite = fk_dim_secactivite;
	}
	public Ima_dim_employeur getFk_dim_employeur() {
		return fk_dim_employeur;
	}
	public void setFk_dim_employeur(Ima_dim_employeur fk_dim_employeur) {
		this.fk_dim_employeur = fk_dim_employeur;
	}
	public Ima_dim_travailleur getFk_dim_travailleur() {
		return fk_dim_travailleur;
	}
	public void setFk_dim_travailleur(Ima_dim_travailleur fk_dim_travailleur) {
		this.fk_dim_travailleur = fk_dim_travailleur;
	}
	public Ima_dim_date getFk_date_motif() {
		return fk_date_motif;
	}
	public void setFk_date_motif(Ima_dim_date fk_date_motif) {
		this.fk_date_motif = fk_date_motif;
	}
	public Ima_dim_categorie_employeur getFk_dim_cat_activite() {
		return fk_dim_cat_activite;
	}
	public void setFk_dim_cat_activite(Ima_dim_categorie_employeur fk_dim_cat_activite) {
		this.fk_dim_cat_activite = fk_dim_cat_activite;
	}
	public Ima_dim_date getFk_date_immatriculation() {
		return fk_date_immatriculation;
	}
	public void setFk_date_immatriculation(Ima_dim_date fk_date_immatriculation) {
		this.fk_date_immatriculation = fk_date_immatriculation;
	}
	public Ima_dim_motif getFk_dim_motif() {
		return fk_dim_motif;
	}
	public void setFk_dim_motif(Ima_dim_motif fk_dim_motif) {
		this.fk_dim_motif = fk_dim_motif;
	}
	public Ima_dim_sexe getFk_dim_sexe() {
		return fk_dim_sexe;
	}
	public void setFk_dim_sexe(Ima_dim_sexe fk_dim_sexe) {
		this.fk_dim_sexe = fk_dim_sexe;
	}
	public Ima_dim_pays getFk_dim_pays() {
		return fk_dim_pays;
	}
	public void setFk_dim_pays(Ima_dim_pays fk_dim_pays) {
		this.fk_dim_pays = fk_dim_pays;
	}
	public Ima_dim_date getFk_date_naissance() {
		return fk_date_naissance;
	}
	public void setFk_date_naissance(Ima_dim_date fk_date_naissance) {
		this.fk_date_naissance = fk_date_naissance;
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
	public int getNombre_travailleur_nouvelle_immatriculation() {
		return nombre_travailleur_nouvelle_immatriculation;
	}
	public void setNombre_travailleur_nouvelle_immatriculation(int nombre_travailleur_nouvelle_immatriculation) {
		this.nombre_travailleur_nouvelle_immatriculation = nombre_travailleur_nouvelle_immatriculation;
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
	public Ima_fait_travailleur_transactionnel(Long cle_fait_transactionnel_travailleur,
			Ima_dim_branche_activite fk_dim_secactivite, Ima_dim_employeur fk_dim_employeur,
			Ima_dim_travailleur fk_dim_travailleur, Ima_dim_date fk_date_motif,
			Ima_dim_categorie_employeur fk_dim_cat_activite, Ima_dim_date fk_date_immatriculation,
			Ima_dim_motif fk_dim_motif, Ima_dim_sexe fk_dim_sexe, Ima_dim_pays fk_dim_pays,
			Ima_dim_date fk_date_naissance, Double salaire_plafonne, Double salaire_non_plafonne,
			int nombre_travailleur_nouvelle_immatriculation, int nombre_travailleur_retraite,
			int nombre_travailleur_decede, int nombre_travailleur_autre_motif) {
		super();
		this.cle_fait_transactionnel_travailleur = cle_fait_transactionnel_travailleur;
		this.fk_dim_secactivite = fk_dim_secactivite;
		this.fk_dim_employeur = fk_dim_employeur;
		this.fk_dim_travailleur = fk_dim_travailleur;
		this.fk_date_motif = fk_date_motif;
		this.fk_dim_cat_activite = fk_dim_cat_activite;
		this.fk_date_immatriculation = fk_date_immatriculation;
		this.fk_dim_motif = fk_dim_motif;
		this.fk_dim_sexe = fk_dim_sexe;
		this.fk_dim_pays = fk_dim_pays;
		this.fk_date_naissance = fk_date_naissance;
		this.salaire_plafonne = salaire_plafonne;
		this.salaire_non_plafonne = salaire_non_plafonne;
		this.nombre_travailleur_nouvelle_immatriculation = nombre_travailleur_nouvelle_immatriculation;
		this.nombre_travailleur_retraite = nombre_travailleur_retraite;
		this.nombre_travailleur_decede = nombre_travailleur_decede;
		this.nombre_travailleur_autre_motif = nombre_travailleur_autre_motif;
	}
	public Ima_fait_travailleur_transactionnel() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
	
}
