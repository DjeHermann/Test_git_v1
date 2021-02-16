package com.osis.cipres.users;

import java.util.Date;

public class AuditRegister {
	
	private String  user;
	private String action;
	private Date actionDate;
	private  String Statut;
	

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
	public AuditRegister(String user, String action, Date actionDate, String statut) {
		super();
		this.user = user;
		this.action = action;
		this.actionDate = actionDate;
		Statut = statut;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public AuditRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return this.user+"  "+this.action+" avec "+this.Statut+" "+this.actionDate+"";
	}


}
