package com.osis.cipres.users;

public class RegisterFormModif {
	
	private String username;
	private String roleName;
	private String newRoleName;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getNewRoleName() {
		return newRoleName;
	}
	public void setNewRoleName(String newRoleName) {
		this.newRoleName = newRoleName;
	}
	public RegisterFormModif(String username, String roleName, String newRoleName) {
		super();
		this.username = username;
		this.roleName = roleName;
		this.newRoleName = newRoleName;
	}
	public RegisterFormModif() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
