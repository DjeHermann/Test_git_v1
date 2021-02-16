package com.osis.cipres.immatriculation.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dat_ima_dim_taille_employeur",schema="data_marts")
public class Ima_dim_taille_employeur {
	@Id
	private Long cle_dim_taille_employeur;
	private Integer tai_code;
	private String tai_libelle;
	
	public Long getCle_dim_taille_employeur() {
		return cle_dim_taille_employeur;
	}
	public void setCle_dim_taille_employeur(Long cle_dim_taille_employeur) {
		this.cle_dim_taille_employeur = cle_dim_taille_employeur;
	}
	public Integer getTai_code() {
		return tai_code;
	}
	public void setTai_code(Integer tai_code) {
		this.tai_code = tai_code;
	}
	public String getTai_libelle() {
		return tai_libelle;
	}
	public void setTai_libelle(String tai_libelle) {
		this.tai_libelle = tai_libelle;
	}
	public Ima_dim_taille_employeur(Long cle_dim_taille_employeur, Integer tai_code, String tai_libelle) {
		super();
		this.cle_dim_taille_employeur = cle_dim_taille_employeur;
		this.tai_code = tai_code;
		this.tai_libelle = tai_libelle;
	}
	public Ima_dim_taille_employeur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
