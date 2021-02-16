package com.osis.cipres.users;

public class RegisterForm {
	
	private String username;
	private String password;
	private String repassword;
	private String email;
	private String pays;
	private String departement;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public RegisterForm(String username, String password, String repassword, String email, String pays,
			String departement) {
		super();
		this.username = username;
		this.password = password;
		this.repassword = repassword;
		this.email = email;
		this.pays = pays;
		this.departement = departement;
	}
	public RegisterForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
