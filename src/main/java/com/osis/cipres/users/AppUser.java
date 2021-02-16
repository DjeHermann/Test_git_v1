package com.osis.cipres.users;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AppUser",schema="users")
public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="user_id_seq")
	@SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq")
	private Long id;
	private String pays;
	private String departement;
	@Column(unique=true)
	private String username;
	private String password;
	private String oldpassword;
	private String email;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "role_id", nullable = false)
	private Collection<AppRole> roles = new ArrayList<>();
	private String imageLink;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public AppUser(Long id, String pays, String departement, String username, String password, String oldpassword,
			String email, Collection<AppRole> roles, String imageLink) {
		super();
		this.id = id;
		this.pays = pays;
		this.departement = departement;
		this.username = username;
		this.password = password;
		this.oldpassword = oldpassword;
		this.email = email;
		this.roles = roles;
		this.imageLink = imageLink;
	}
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
