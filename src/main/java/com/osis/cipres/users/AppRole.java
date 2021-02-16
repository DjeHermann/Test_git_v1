package com.osis.cipres.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AppRole",schema="users")
public class AppRole {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="role_id_seq")
	@SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq")
	private Long id;
	private String roleName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public AppRole(Long id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	public AppRole() {
		super();
		// TODO Auto-generated constructor stub
	}
}
