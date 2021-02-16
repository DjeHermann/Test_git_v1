package com.osis.cipres.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	
AppUser findByUsername(String username);
	
	@Query("Select c From AppUser c Where c.id=:id")
	public AppUser findOne(@Param("id")Long id);
	
	@Query("Select c From AppUser c Where c.username=:username")
	public AppUser findByName(@Param("username")String username);
	@Query("SELECT c From AppUser c WHERE c.username=:username AND c.email=:email")
	public AppUser verifuserinfos(@Param("username")String username, @Param("email")String email);
	
	@Query("SELECT c From AppUser c WHERE c.email=:email")
	public AppUser findByEmail( @Param("email")String email);
	

}
