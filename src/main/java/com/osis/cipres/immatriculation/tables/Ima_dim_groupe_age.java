package com.osis.cipres.immatriculation.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dat_ima_dim_groupe_age",schema="data_marts")
public class Ima_dim_groupe_age {
	@Id
	private Long cle_dim_groupe_age;
	private Integer grp_code;
	private String grp_libelle;
	public Long getCle_dim_groupe_age() {
		return cle_dim_groupe_age;
	}
	public void setCle_dim_groupe_age(Long cle_dim_groupe_age) {
		this.cle_dim_groupe_age = cle_dim_groupe_age;
	}
	public Integer getGrp_code() {
		return grp_code;
	}
	public void setGrp_code(Integer grp_code) {
		this.grp_code = grp_code;
	}
	public String getGrp_libelle() {
		return grp_libelle;
	}
	public void setGrp_libelle(String grp_libelle) {
		this.grp_libelle = grp_libelle;
	}
	public Ima_dim_groupe_age(Long cle_dim_groupe_age, Integer grp_code, String grp_libelle) {
		super();
		this.cle_dim_groupe_age = cle_dim_groupe_age;
		this.grp_code = grp_code;
		this.grp_libelle = grp_libelle;
	}
	public Ima_dim_groupe_age() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
