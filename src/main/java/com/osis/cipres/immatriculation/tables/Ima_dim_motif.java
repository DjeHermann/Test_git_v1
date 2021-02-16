package com.osis.cipres.immatriculation.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dat_ima_dim_motif",schema="data_marts")
public class Ima_dim_motif {
	@Id
	private Long cle_dim_motif;
	private Integer motcode;
	private String motlibel;
	private String motremarque;
	
	public Long getCle_dim_motif() {
		return cle_dim_motif;
	}
	public void setCle_dim_motif(Long cle_dim_motif) {
		this.cle_dim_motif = cle_dim_motif;
	}
	public Integer getMotcode() {
		return motcode;
	}
	public void setMotcode(Integer motcode) {
		this.motcode = motcode;
	}
	public String getMotlibel() {
		return motlibel;
	}
	public void setMotlibel(String motlibel) {
		this.motlibel = motlibel;
	}
	public String getMotremarque() {
		return motremarque;
	}
	public void setMotremarque(String motremarque) {
		this.motremarque = motremarque;
	}
	public Ima_dim_motif(Long cle_dim_motif, Integer motcode, String motlibel, String motremarque) {
		super();
		this.cle_dim_motif = cle_dim_motif;
		this.motcode = motcode;
		this.motlibel = motlibel;
		this.motremarque = motremarque;
	}
	public Ima_dim_motif() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
