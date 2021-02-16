package com.osis.cipres.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
	
	public AppRole findByRoleName(String roleName);

}
