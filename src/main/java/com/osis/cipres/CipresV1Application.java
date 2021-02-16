package com.osis.cipres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.osis.cipres.property.FileStorageProperties;
import com.osis.cipres.users.AccountServices;
import com.osis.cipres.users.AppUser;



@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class CipresV1Application implements CommandLineRunner{
	
	@Autowired
	private AccountServices accountServices;

	public static void main(String[] args) {
		SpringApplication.run(CipresV1Application.class, args);
	}

	 @Bean public BCryptPasswordEncoder bCryptPasswordEncoder() { 
		  return new BCryptPasswordEncoder();
	  }
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		AppUser appUser = new AppUser();
//		  appUser.setUsername("admin");
//		  appUser.setPassword("admin123");
//		  accountServices.saveUser(appUser);
		  
		/*AppRole role1 = new AppRole();
		role1.setRoleName("ADMIN");
		accountService.saveRole(role1);*/
		
//		AppUser user =accountServices.findByUsername("admin");
//		accountServices.addRoleToUser(user.getUsername(),"ADMIN");
	
	}
	
	  


}
