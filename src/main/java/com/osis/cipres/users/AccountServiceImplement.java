package com.osis.cipres.users;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.osis.cipres.mailing.MailRequest;

@Service
@Transactional
public class AccountServiceImplement implements AccountServices {
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired 
	private AppRoleRepository appRoleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public AppUser saveUser(AppUser user) {
		// TODO Auto-generated method stub
		String hasPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hasPassword);
		user.setOldpassword(hasPassword);
		return appUserRepository.save(user);
	}

	public AppUser findByUsername(String username) {
		// TODO Auto-generated method stub
	
		return appUserRepository.findByUsername(username);
	}

	public List<AppUser> getUserList() {
		// TODO Auto-generated method stub
		return appUserRepository.findAll();
	}

	public AppUser updateUser(AppUser user) {
		// TODO Auto-generated method stub
		return appUserRepository.saveAndFlush(user);
	}

	public void userDelete(String username) {
		// TODO Auto-generated method stub
		AppUser user = appUserRepository.findByUsername(username);
		appUserRepository.delete(user);	
	}

	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		appUserRepository.deleteById(id);
	}

	public AppRole saveRole(AppRole role) {
		// TODO Auto-generated method stub
		return appRoleRepository.save(role);
	}

	public List<AppRole> getUserRole() {
		// TODO Auto-generated method stub
		return appRoleRepository.findAll();
	}

	public void addRoleToUser(String usermane, String roleName) {
		// TODO Auto-generated method stub
			System.out.println(usermane);
			System.out.println(roleName);
				AppRole role = appRoleRepository.findByRoleName(roleName);
				System.out.println("d1"+roleName);
				if(role==null) {
					AppRole newrole = new AppRole();
					newrole.setRoleName(roleName);
					appRoleRepository.save(newrole);
					AppUser usered = appUserRepository.findByUsername(usermane);
					System.out.println("d2"+roleName);
					usered.getRoles().add(newrole);	
				}else {
					System.out.println("d3"+usermane);
					AppUser user = appUserRepository.findByName(usermane);
					System.out.println("d4"+user.getUsername());
					System.out.println("d5"+role.getRoleName());
					user.getRoles().add(role);
				}
		
	}

	public String changerPassword(UserForm userForm) {
		// TODO Auto-generated method stub
		String resultat="";
		AppUser user = appUserRepository.findByUsername(userForm.getUsername());
		
		if (user != null) {
			
			//je crypte le nouveau et l'ancien mot de passe
			

			//String hashOldPassword = bCryptPasswordEncoder.encode(userForm.getOldPassword());
			String hashNewPassword = bCryptPasswordEncoder.encode(userForm.getNewPassword());
			
			
			//Je compare l'ancien mot de passe de la base de donnée et l'ancien mot de passe saisi
			/*System.out.println(BCrypt.checkpw(userForm.getOldPassword(), user.getPassword()));
			System.out.println(userForm.getOldPassword());
			System.out.println(user.getPassword());
			if(user.getPassword().equals(hashOldPassword)){*/
			
			if(BCrypt.checkpw(userForm.getOldPassword(), user.getPassword())){
				
				if(BCrypt.checkpw(userForm.getNewPassword(), user.getOldpassword())) {
					
					
					resultat="Mot de passe deja utilisé";
				    return resultat;
				}
				
					//Je verifie la confirmation du mot de passe		
					
					if(userForm.getNewPassword().equals(userForm.getConfirmPassword())){
						
						user.setPassword(hashNewPassword);
						user.setOldpassword(hashNewPassword);
						//user.setStatut(true)
						appUserRepository.save(user);
					
						resultat = "Le mot de passe a été modifié avec succès";
						
					}else
						{
						resultat ="La confirmation du mot de passe est incorrecte";
						}
			
			}else
				{
				resultat ="L ancien mot de passe que vous avez saisi est incorrect";
				}
		}
		  
	    	else 
	    	{
	    		resultat ="Le compte que vous tentez de modifier est introuvable";
	    	}
				
		return resultat;

	}

	public AppUser updateUserRole(RegisterFormModif info) {
		// TODO Auto-generated method stub
		AppRole role =	appRoleRepository.findByRoleName(info.getRoleName());
		AppRole newRole = appRoleRepository.findByRoleName(info.getNewRoleName());
		AppUser user = appUserRepository.findByUsername(info.getUsername());
		if(user== null)
			throw new RuntimeException("ce utilisteur n'existe pas");
		user.getRoles().remove(role);
		user.getRoles().add(newRole);
		return appUserRepository.saveAndFlush(user);
	}

	public AppUser deleteUserRole(RegisterFormDelete info) {
		// TODO Auto-generated method stub
		String resultat="";
		AppUser user = appUserRepository.findByUsername(info.getUsername());
		AppRole role =	appRoleRepository.findByRoleName(info.getRoleName());
		if(user== null)
			throw new RuntimeException("ce utilisteur n'existe pas");
		user.getRoles().remove(role);
		resultat="rôle supprimé avec succès";
		return appUserRepository.saveAndFlush(user);
	}

	
	public MailRequest verifuserinfos(String username, String email) {
		// TODO Auto-generated method stub
		String from = "equipebiosis@gmail.com";
		AppUser user = appUserRepository.findByUsername(username);
		MailRequest mail = new MailRequest();
		//System.out.println(user.getEmail());
		
		if (user== null)
			throw new RuntimeException("cet utilisteur n'existe pas");
		mail.setName(user.getUsername());
		if(user.getEmail().equals(email)) {
			mail.setTo(user.getEmail());
			mail.setFrom(from);
			mail.setSubject("Réinitialisation du mot de passe");
		}    	
		return mail;
	}
	
	
	

	public String reinitialiserPassword(AppUser user, String newCode) {
		// TODO Auto-generated method stub
		String hashCode = bCryptPasswordEncoder.encode(newCode);
		user.setOldpassword(user.getPassword());
		user.setPassword(hashCode);
	//	user.setStatut(true);
		 appUserRepository.saveAndFlush(user);
		 return "Le mot de passe a été réinitialisé avec succès";
	}

	public List<AppRole> getRoleList() {
		// TODO Auto-generated method stub
		return appRoleRepository.findAll();
	}
	

}
