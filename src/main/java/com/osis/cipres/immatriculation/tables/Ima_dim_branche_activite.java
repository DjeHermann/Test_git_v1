package com.osis.cipres.immatriculation.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dat_ima_dim_secactivite",schema="data_marts")
public class Ima_dim_branche_activite {
	@Id
	private Long cle_dim_secactivite;
	private Integer seccode;
	private String seclibel;
	private Double sectaux;
	public Long getCle_dim_secactivite() {
		return cle_dim_secactivite;
	}
	public void setCle_dim_secactivite(Long cle_dim_secactivite) {
		this.cle_dim_secactivite = cle_dim_secactivite;
	}
	public Integer getSeccode() {
		return seccode;
	}
	public void setSeccode(Integer seccode) {
		this.seccode = seccode;
	}
	public String getSeclibel() {
		return seclibel;
	}
	public void setSeclibel(String seclibel) {
		this.seclibel = seclibel;
	}
	public Double getSectaux() {
		return sectaux;
	}
	public void setSectaux(Double sectaux) {
		this.sectaux = sectaux;
	}
	public Ima_dim_branche_activite(Long cle_dim_secactivite, Integer seccode, String seclibel, Double sectaux) {
		super();
		this.cle_dim_secactivite = cle_dim_secactivite;
		this.seccode = seccode;
		this.seclibel = seclibel;
		this.sectaux = sectaux;
	}
	public Ima_dim_branche_activite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
