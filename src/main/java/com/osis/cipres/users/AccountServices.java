package com.osis.cipres.users;

import java.util.List;

import com.osis.cipres.mailing.MailRequest;

public interface AccountServices {
	
	public AppUser saveUser(AppUser user);
	public AppUser findByUsername(String username);
	public List<AppUser>getUserList();
	public AppUser updateUser(AppUser c);
	public void userDelete (String username);
	public void deleteUserById(Long id);
	
	
	public AppRole saveRole(AppRole role);
	public List<AppRole>getUserRole();
	public List<AppRole> getRoleList();
	public void addRoleToUser(String usermane, String roleName);
	
	
	
	public String changerPassword(UserForm userForm);
	public AppUser updateUserRole(RegisterFormModif info);
	public AppUser deleteUserRole(RegisterFormDelete info);
	
	public MailRequest verifuserinfos(String username, String email);
	
	public String reinitialiserPassword(AppUser user, String newCode);

}
