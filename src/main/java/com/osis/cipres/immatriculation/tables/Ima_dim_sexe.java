package com.osis.cipres.immatriculation.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dat_ima_dim_sexe",schema="data_marts")
public class Ima_dim_sexe {
	@Id
	private Long cle_dim_sexe;
	private Integer sex_code;
	private String sex_libelle;
	
	public Long getCle_dim_sexe() {
		return cle_dim_sexe;
	}
	public void setCle_dim_sexe(Long cle_dim_sexe) {
		this.cle_dim_sexe = cle_dim_sexe;
	}
	public Integer getSex_code() {
		return sex_code;
	}
	public void setSex_code(Integer sex_code) {
		this.sex_code = sex_code;
	}
	public String getSex_libelle() {
		return sex_libelle;
	}
	public void setSex_libelle(String sex_libelle) {
		this.sex_libelle = sex_libelle;
	}
	public Ima_dim_sexe(Long cle_dim_sexe, Integer sex_code, String sex_libelle) {
		super();
		this.cle_dim_sexe = cle_dim_sexe;
		this.sex_code = sex_code;
		this.sex_libelle = sex_libelle;
	}
	public Ima_dim_sexe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
