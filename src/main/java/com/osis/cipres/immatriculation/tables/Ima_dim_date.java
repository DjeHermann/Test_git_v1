package com.osis.cipres.immatriculation.tables;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dat_ima_dim_date",schema="data_marts")
public class Ima_dim_date {
	@Id
	private Long cle_date;
	private Date date_complete;
	private String nom_date;
	private Integer no_jour_semaine;
	private String nom_jour_semaine;
	private String nom_jour_semaine_abrege;
	private Integer no_semaine;
	private Integer no_jour_mois;
	private Integer no_jour_annee;
	private Integer no_mois;
	private String nom_mois;
	private String nom_mois_abrege;
	private String no_nom_mois;
	private String indict_dernier_jour_mois;
	private String type_jour_semaine;
	private Integer no_semestre;
	private Integer no_trimestre;
	private Integer no_annee;
	private String no_mois_annee;
	
	public Ima_dim_date() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ima_dim_date(Long cle_date, Date date_complete, String nom_date, Integer no_jour_semaine,
			String nom_jour_semaine, String nom_jour_semaine_abrege, Integer no_semaine, Integer no_jour_mois,
			Integer no_jour_annee, Integer no_mois, String nom_mois, String nom_mois_abrege, String no_nom_mois,
			String indict_dernier_jour_mois, String type_jour_semaine, Integer no_semestre, Integer no_trimestre,
			Integer no_annee, String no_mois_annee) {
		super();
		this.cle_date = cle_date;
		this.date_complete = date_complete;
		this.nom_date = nom_date;
		this.no_jour_semaine = no_jour_semaine;
		this.nom_jour_semaine = nom_jour_semaine;
		this.nom_jour_semaine_abrege = nom_jour_semaine_abrege;
		this.no_semaine = no_semaine;
		this.no_jour_mois = no_jour_mois;
		this.no_jour_annee = no_jour_annee;
		this.no_mois = no_mois;
		this.nom_mois = nom_mois;
		this.nom_mois_abrege = nom_mois_abrege;
		this.no_nom_mois = no_nom_mois;
		this.indict_dernier_jour_mois = indict_dernier_jour_mois;
		this.type_jour_semaine = type_jour_semaine;
		this.no_semestre = no_semestre;
		this.no_trimestre = no_trimestre;
		this.no_annee = no_annee;
		this.no_mois_annee = no_mois_annee;
	}

	public Long getCle_date() {
		return cle_date;
	}

	public void setCle_date(Long cle_date) {
		this.cle_date = cle_date;
	}

	public Date getDate_complete() {
		return date_complete;
	}

	public void setDate_complete(Date date_complete) {
		this.date_complete = date_complete;
	}

	public String getNom_date() {
		return nom_date;
	}

	public void setNom_date(String nom_date) {
		this.nom_date = nom_date;
	}

	public Integer getNo_jour_semaine() {
		return no_jour_semaine;
	}

	public void setNo_jour_semaine(Integer no_jour_semaine) {
		this.no_jour_semaine = no_jour_semaine;
	}

	public String getNom_jour_semaine() {
		return nom_jour_semaine;
	}

	public void setNom_jour_semaine(String nom_jour_semaine) {
		this.nom_jour_semaine = nom_jour_semaine;
	}

	public String getNom_jour_semaine_abrege() {
		return nom_jour_semaine_abrege;
	}

	public void setNom_jour_semaine_abrege(String nom_jour_semaine_abrege) {
		this.nom_jour_semaine_abrege = nom_jour_semaine_abrege;
	}

	public Integer getNo_semaine() {
		return no_semaine;
	}

	public void setNo_semaine(Integer no_semaine) {
		this.no_semaine = no_semaine;
	}

	public Integer getNo_jour_mois() {
		return no_jour_mois;
	}

	public void setNo_jour_mois(Integer no_jour_mois) {
		this.no_jour_mois = no_jour_mois;
	}

	public Integer getNo_jour_annee() {
		return no_jour_annee;
	}

	public void setNo_jour_annee(Integer no_jour_annee) {
		this.no_jour_annee = no_jour_annee;
	}

	public Integer getNo_mois() {
		return no_mois;
	}

	public void setNo_mois(Integer no_mois) {
		this.no_mois = no_mois;
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

	public String getNo_nom_mois() {
		return no_nom_mois;
	}

	public void setNo_nom_mois(String no_nom_mois) {
		this.no_nom_mois = no_nom_mois;
	}

	public String getIndict_dernier_jour_mois() {
		return indict_dernier_jour_mois;
	}

	public void setIndict_dernier_jour_mois(String indict_dernier_jour_mois) {
		this.indict_dernier_jour_mois = indict_dernier_jour_mois;
	}

	public String getType_jour_semaine() {
		return type_jour_semaine;
	}

	public void setType_jour_semaine(String type_jour_semaine) {
		this.type_jour_semaine = type_jour_semaine;
	}

	public Integer getNo_semestre() {
		return no_semestre;
	}

	public void setNo_semestre(Integer no_semestre) {
		this.no_semestre = no_semestre;
	}

	public Integer getNo_trimestre() {
		return no_trimestre;
	}

	public void setNo_trimestre(Integer no_trimestre) {
		this.no_trimestre = no_trimestre;
	}

	public Integer getNo_annee() {
		return no_annee;
	}

	public void setNo_annee(Integer no_annee) {
		this.no_annee = no_annee;
	}

	public String getNo_mois_annee() {
		return no_mois_annee;
	}

	public void setNo_mois_annee(String no_mois_annee) {
		this.no_mois_annee = no_mois_annee;
	}
	
	
	
	
	
}
