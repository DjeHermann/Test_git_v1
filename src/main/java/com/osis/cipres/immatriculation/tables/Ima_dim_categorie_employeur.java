package com.osis.cipres.immatriculation.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dat_ima_dim_categorie_activite",schema="data_marts")
public class Ima_dim_categorie_employeur {
	@Id
	private Long cle_dim_cat_activite;
	private Integer cat_code;
	private String cat_libelle;
	
	public Long getCle_dim_cat_activite() {
		return cle_dim_cat_activite;
	}
	public void setCle_dim_cat_activite(Long cle_dim_cat_activite) {
		this.cle_dim_cat_activite = cle_dim_cat_activite;
	}
	public Integer getCat_code() {
		return cat_code;
	}
	public void setCat_code(Integer cat_code) {
		this.cat_code = cat_code;
	}
	public String getCat_libelle() {
		return cat_libelle;
	}
	public void setCat_libelle(String cat_libelle) {
		this.cat_libelle = cat_libelle;
	}
	public Ima_dim_categorie_employeur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ima_dim_categorie_employeur(Long cle_dim_cat_activite, Integer cat_code, String cat_libelle) {
		super();
		this.cle_dim_cat_activite = cle_dim_cat_activite;
		this.cat_code = cat_code;
		this.cat_libelle = cat_libelle;
	}
	
	
	
}
