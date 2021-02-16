package com.osis.cipres.users;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class AuditUser {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="auditUser_id_seq")
	@SequenceGenerator(name = "auditUser_id_seq", sequenceName = "auditUser_id_seq")
	private Long id;
	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.REMOVE)
	private AppUser  user;
	private String action;
	private Date actionDate;
	private  String Statut;
	public AuditUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuditUser(Long id, AppUser userName, String action, Date actionDate, String statut) {
		super();
		this.id = id;
		this.user = userName;
		this.action = action;
		this.actionDate = actionDate;
		Statut = statut;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AppUser getUser() {
		return user;
	}
	public void setUser(AppUser userName) {
		this.user = userName;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Date getActionDate() {
		return actionDate;
	}
	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
	public String getStatut() {
		return Statut;
	}
	public void setStatut(String statut) {
		Statut = statut;
	}
	

}
