package com.osis.cipres.users;

public class RegisterFormDelete {

	private String username;
	private String roleName;
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
	public RegisterFormDelete(String username, String roleName) {
		super();
		this.username = username;
		this.roleName = roleName;
	}
	public RegisterFormDelete() {
		super();
		// TODO Auto-generated constructor stub
	}
}
