package com.osis.cipres.immatriculation.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dat_ima_dim_pays",schema="data_marts")
public class Ima_dim_pays {
	@Id
	private Long cle_dim_pays;
	private Integer pay_code;
	private String pay_libelle;
	
	public Long getCle_dim_pays() {
		return cle_dim_pays;
	}
	public void setCle_dim_pays(Long cle_dim_pays) {
		this.cle_dim_pays = cle_dim_pays;
	}
	public Integer getPay_code() {
		return pay_code;
	}
	public void setPay_code(Integer pay_code) {
		this.pay_code = pay_code;
	}
	public String getPay_libelle() {
		return pay_libelle;
	}
	public void setPay_libelle(String pay_libelle) {
		this.pay_libelle = pay_libelle;
	}
	public Ima_dim_pays(Long cle_dim_pays, Integer pay_code, String pay_libelle) {
		super();
		this.cle_dim_pays = cle_dim_pays;
		this.pay_code = pay_code;
		this.pay_libelle = pay_libelle;
	}
	public Ima_dim_pays() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
