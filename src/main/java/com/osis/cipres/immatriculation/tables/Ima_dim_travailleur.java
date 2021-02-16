package com.osis.cipres.immatriculation.tables;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dat_ima_dim_travailleur",schema="data_marts")
public class Ima_dim_travailleur {
	@Id
	private Long cle_dim_travailleur;
	private Integer trv_numero_cnps;
	private String trv_nom;
	private String trv_prenom;
	private String trv_nom_jeune_fille;
	private String trv_sexe;
	private String trv_situation_mat;
	private String trv_profession;
	private String trv_code_agence;
	private String trv_codena;
	private String trv_portable;
	private Date trv_date_immatriculation;
	private String trv_telephone;
	private String trv_email;
	private String trv_indicatif_portable;
	private Integer version;
	private Date date_debut;
	private Date date_fin;
	
	public Long getCle_dim_travailleur() {
		return cle_dim_travailleur;
	}
	public void setCle_dim_travailleur(Long cle_dim_travailleur) {
		this.cle_dim_travailleur = cle_dim_travailleur;
	}
	public Integer getTrv_numero_cnps() {
		return trv_numero_cnps;
	}
	public void setTrv_numero_cnps(Integer trv_numero_cnps) {
		this.trv_numero_cnps = trv_numero_cnps;
	}
	public String getTrv_nom() {
		return trv_nom;
	}
	public void setTrv_nom(String trv_nom) {
		this.trv_nom = trv_nom;
	}
	public String getTrv_prenom() {
		return trv_prenom;
	}
	public void setTrv_prenom(String trv_prenom) {
		this.trv_prenom = trv_prenom;
	}
	public String getTrv_nom_jeune_fille() {
		return trv_nom_jeune_fille;
	}
	public void setTrv_nom_jeune_fille(String trv_nom_jeune_fille) {
		this.trv_nom_jeune_fille = trv_nom_jeune_fille;
	}
	public String getTrv_sexe() {
		return trv_sexe;
	}
	public void setTrv_sexe(String trv_sexe) {
		this.trv_sexe = trv_sexe;
	}
	public String getTrv_situation_mat() {
		return trv_situation_mat;
	}
	public void setTrv_situation_mat(String trv_situation_mat) {
		this.trv_situation_mat = trv_situation_mat;
	}
	public String getTrv_profession() {
		return trv_profession;
	}
	public void setTrv_profession(String trv_profession) {
		this.trv_profession = trv_profession;
	}
	public String getTrv_code_agence() {
		return trv_code_agence;
	}
	public void setTrv_code_agence(String trv_code_agence) {
		this.trv_code_agence = trv_code_agence;
	}
	public String getTrv_codena() {
		return trv_codena;
	}
	public void setTrv_codena(String trv_codena) {
		this.trv_codena = trv_codena;
	}
	public String getTrv_portable() {
		return trv_portable;
	}
	public void setTrv_portable(String trv_portable) {
		this.trv_portable = trv_portable;
	}
	public Date getTrv_date_immatriculation() {
		return trv_date_immatriculation;
	}
	public void setTrv_date_immatriculation(Date trv_date_immatriculation) {
		this.trv_date_immatriculation = trv_date_immatriculation;
	}
	public String getTrv_telephone() {
		return trv_telephone;
	}
	public void setTrv_telephone(String trv_telephone) {
		this.trv_telephone = trv_telephone;
	}
	public String getTrv_email() {
		return trv_email;
	}
	public void setTrv_email(String trv_email) {
		this.trv_email = trv_email;
	}
	public String getTrv_indicatif_portable() {
		return trv_indicatif_portable;
	}
	public void setTrv_indicatif_portable(String trv_indicatif_portable) {
		this.trv_indicatif_portable = trv_indicatif_portable;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public Ima_dim_travailleur(Long cle_dim_travailleur, Integer trv_numero_cnps, String trv_nom, String trv_prenom,
			String trv_nom_jeune_fille, String trv_sexe, String trv_situation_mat, String trv_profession,
			String trv_code_agence, String trv_codena, String trv_portable, Date trv_date_immatriculation,
			String trv_telephone, String trv_email, String trv_indicatif_portable, Integer version, Date date_debut,
			Date date_fin) {
		super();
		this.cle_dim_travailleur = cle_dim_travailleur;
		this.trv_numero_cnps = trv_numero_cnps;
		this.trv_nom = trv_nom;
		this.trv_prenom = trv_prenom;
		this.trv_nom_jeune_fille = trv_nom_jeune_fille;
		this.trv_sexe = trv_sexe;
		this.trv_situation_mat = trv_situation_mat;
		this.trv_profession = trv_profession;
		this.trv_code_agence = trv_code_agence;
		this.trv_codena = trv_codena;
		this.trv_portable = trv_portable;
		this.trv_date_immatriculation = trv_date_immatriculation;
		this.trv_telephone = trv_telephone;
		this.trv_email = trv_email;
		this.trv_indicatif_portable = trv_indicatif_portable;
		this.version = version;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public Ima_dim_travailleur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
