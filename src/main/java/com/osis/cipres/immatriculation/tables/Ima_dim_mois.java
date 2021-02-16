package com.osis.cipres.immatriculation.tables;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dat_ima_dim_mois",schema="data_marts")
public class Ima_dim_mois {
	@Id
	private Long cle_mois;
	private String nom_mois;
	private String nom_mois_abrege;
	private Integer no_mois;
	private String no_nom_mois;
	private Date date_fin_mois;
	private Integer no_trimestre;
	private Integer no_semestre;
	private Integer no_annee;
	private String mois_annee;
	
	public Ima_dim_mois() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ima_dim_mois(Long cle_mois, String nom_mois, String nom_mois_abrege, Integer no_mois, String no_nom_mois,
			Date date_fin_mois, Integer no_trimestre, Integer no_semestre, Integer no_annee, String mois_annee) {
		super();
		this.cle_mois = cle_mois;
		this.nom_mois = nom_mois;
		this.nom_mois_abrege = nom_mois_abrege;
		this.no_mois = no_mois;
		this.no_nom_mois = no_nom_mois;
		this.date_fin_mois = date_fin_mois;
		this.no_trimestre = no_trimestre;
		this.no_semestre = no_semestre;
		this.no_annee = no_annee;
		this.mois_annee = mois_annee;
	}

	public Long getCle_mois() {
		return cle_mois;
	}

	public void setCle_mois(Long cle_mois) {
		this.cle_mois = cle_mois;
	}

	public String getNom_mois() {
		return nom_mois;
	}

	public void setNom_mois(String nom_mois) {
		this.nom_mois = nom_mois;
	}

	public String getNom_mois_abrege() {
		return nom_mois_abrege;
	}

	public void setNom_mois_abrege(String nom_mois_abrege) {
		this.nom_mois_abrege = nom_mois_abrege;
	}

	public Integer getNo_mois() {
		return no_mois;
	}

	public void setNo_mois(Integer no_mois) {
		this.no_mois = no_mois;
	}

	public String getNo_nom_mois() {
		return no_nom_mois;
	}

	public void setNo_nom_mois(String no_nom_mois) {
		this.no_nom_mois = no_nom_mois;
	}

	public Date getDate_fin_mois() {
		return date_fin_mois;
	}

	public void setDate_fin_mois(Date date_fin_mois) {
		this.date_fin_mois = date_fin_mois;
	}

	public Integer getNo_trimestre() {
		return no_trimestre;
	}

	public void setNo_trimestre(Integer no_trimestre) {
		this.no_trimestre = no_trimestre;
	}

	public Integer getNo_semestre() {
		return no_semestre;
	}

	public void setNo_semestre(Integer no_semestre) {
		this.no_semestre = no_semestre;
	}

	public Integer getNo_annee() {
		return no_annee;
	}

	public void setNo_annee(Integer no_annee) {
		this.no_annee = no_annee;
	}

	public String getMois_annee() {
		return mois_annee;
	}

	public void setMois_annee(String mois_annee) {
		this.mois_annee = mois_annee;
	}
	
	
	
	
	
}
