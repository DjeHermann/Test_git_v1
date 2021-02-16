package com.osis.cipres.immatriculation.tables;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dat_ima_dim_employeur",schema="data_marts")
public class Ima_dim_employeur {
	@Id
	private Long cle_dim_employeur;
	private Integer emp_numero_cnps;
	private String emp_raison_sociale;
	private String emp_sigle;
	private Date emp_date_immatriculation;
	private Date emp_date_debut_activite;
	private Date emp_date_prem_embauche;
	private String emp_forme_juridique;
	private String emp_period_paiement;
	private Integer emp_code_agence;
	private Integer emp_code_commune;
	private Integer emp_code_quartier;
	private String emp_telephone;
	private String emp_fax;
	private String emp_adresse_physique;
	private String emp_dernier_motif;
	private Date emp_date_dernier_motif;
	private String emp_teleph_portable;
	private String emp_email1;
	private String emp_email2;
	private String emp_email3;
	private Integer version;
	private Date date_debut;
	private Date date_fin;
	public Long getCle_dim_employeur() {
		return cle_dim_employeur;
	}
	public void setCle_dim_employeur(Long cle_dim_employeur) {
		this.cle_dim_employeur = cle_dim_employeur;
	}
	public Integer getEmp_numero_cnps() {
		return emp_numero_cnps;
	}
	public void setEmp_numero_cnps(Integer emp_numero_cnps) {
		this.emp_numero_cnps = emp_numero_cnps;
	}
	public String getEmp_raison_sociale() {
		return emp_raison_sociale;
	}
	public void setEmp_raison_sociale(String emp_raison_sociale) {
		this.emp_raison_sociale = emp_raison_sociale;
	}
	public String getEmp_sigle() {
		return emp_sigle;
	}
	public void setEmp_sigle(String emp_sigle) {
		this.emp_sigle = emp_sigle;
	}
	public Date getEmp_date_immatriculation() {
		return emp_date_immatriculation;
	}
	public void setEmp_date_immatriculation(Date emp_date_immatriculation) {
		this.emp_date_immatriculation = emp_date_immatriculation;
	}
	public Date getEmp_date_debut_activite() {
		return emp_date_debut_activite;
	}
	public void setEmp_date_debut_activite(Date emp_date_debut_activite) {
		this.emp_date_debut_activite = emp_date_debut_activite;
	}
	public Date getEmp_date_prem_embauche() {
		return emp_date_prem_embauche;
	}
	public void setEmp_date_prem_embauche(Date emp_date_prem_embauche) {
		this.emp_date_prem_embauche = emp_date_prem_embauche;
	}
	public String getEmp_forme_juridique() {
		return emp_forme_juridique;
	}
	public void setEmp_forme_juridique(String emp_forme_juridique) {
		this.emp_forme_juridique = emp_forme_juridique;
	}
	public String getEmp_period_paiement() {
		return emp_period_paiement;
	}
	public void setEmp_period_paiement(String emp_period_paiement) {
		this.emp_period_paiement = emp_period_paiement;
	}
	public Integer getEmp_code_agence() {
		return emp_code_agence;
	}
	public void setEmp_code_agence(Integer emp_code_agence) {
		this.emp_code_agence = emp_code_agence;
	}
	public Integer getEmp_code_commune() {
		return emp_code_commune;
	}
	public void setEmp_code_commune(Integer emp_code_commune) {
		this.emp_code_commune = emp_code_commune;
	}
	public Integer getEmp_code_quartier() {
		return emp_code_quartier;
	}
	public void setEmp_code_quartier(Integer emp_code_quartier) {
		this.emp_code_quartier = emp_code_quartier;
	}
	public String getEmp_telephone() {
		return emp_telephone;
	}
	public void setEmp_telephone(String emp_telephone) {
		this.emp_telephone = emp_telephone;
	}
	public String getEmp_fax() {
		return emp_fax;
	}
	public void setEmp_fax(String emp_fax) {
		this.emp_fax = emp_fax;
	}
	public String getEmp_adresse_physique() {
		return emp_adresse_physique;
	}
	public void setEmp_adresse_physique(String emp_adresse_physique) {
		this.emp_adresse_physique = emp_adresse_physique;
	}
	public String getEmp_dernier_motif() {
		return emp_dernier_motif;
	}
	public void setEmp_dernier_motif(String emp_dernier_motif) {
		this.emp_dernier_motif = emp_dernier_motif;
	}
	public Date getEmp_date_dernier_motif() {
		return emp_date_dernier_motif;
	}
	public void setEmp_date_dernier_motif(Date emp_date_dernier_motif) {
		this.emp_date_dernier_motif = emp_date_dernier_motif;
	}
	public String getEmp_teleph_portable() {
		return emp_teleph_portable;
	}
	public void setEmp_teleph_portable(String emp_teleph_portable) {
		this.emp_teleph_portable = emp_teleph_portable;
	}
	public String getEmp_email1() {
		return emp_email1;
	}
	public void setEmp_email1(String emp_email1) {
		this.emp_email1 = emp_email1;
	}
	public String getEmp_email2() {
		return emp_email2;
	}
	public void setEmp_email2(String emp_email2) {
		this.emp_email2 = emp_email2;
	}
	public String getEmp_email3() {
		return emp_email3;
	}
	public void setEmp_email3(String emp_email3) {
		this.emp_email3 = emp_email3;
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
	public Ima_dim_employeur(Long cle_dim_employeur, Integer emp_numero_cnps, String emp_raison_sociale,
			String emp_sigle, Date emp_date_immatriculation, Date emp_date_debut_activite, Date emp_date_prem_embauche,
			String emp_forme_juridique, String emp_period_paiement, Integer emp_code_agence, Integer emp_code_commune,
			Integer emp_code_quartier, String emp_telephone, String emp_fax, String emp_adresse_physique,
			String emp_dernier_motif, Date emp_date_dernier_motif, String emp_teleph_portable, String emp_email1,
			String emp_email2, String emp_email3, Integer version, Date date_debut, Date date_fin) {
		super();
		this.cle_dim_employeur = cle_dim_employeur;
		this.emp_numero_cnps = emp_numero_cnps;
		this.emp_raison_sociale = emp_raison_sociale;
		this.emp_sigle = emp_sigle;
		this.emp_date_immatriculation = emp_date_immatriculation;
		this.emp_date_debut_activite = emp_date_debut_activite;
		this.emp_date_prem_embauche = emp_date_prem_embauche;
		this.emp_forme_juridique = emp_forme_juridique;
		this.emp_period_paiement = emp_period_paiement;
		this.emp_code_agence = emp_code_agence;
		this.emp_code_commune = emp_code_commune;
		this.emp_code_quartier = emp_code_quartier;
		this.emp_telephone = emp_telephone;
		this.emp_fax = emp_fax;
		this.emp_adresse_physique = emp_adresse_physique;
		this.emp_dernier_motif = emp_dernier_motif;
		this.emp_date_dernier_motif = emp_date_dernier_motif;
		this.emp_teleph_portable = emp_teleph_portable;
		this.emp_email1 = emp_email1;
		this.emp_email2 = emp_email2;
		this.emp_email3 = emp_email3;
		this.version = version;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public Ima_dim_employeur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	}
