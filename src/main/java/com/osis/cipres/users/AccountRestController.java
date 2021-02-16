package com.osis.cipres.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.osis.cipres.mailing.EmailService;
import com.osis.cipres.mailing.MailRequest;
import com.osis.cipres.mailing.MailResponse;
import com.osis.cipres.mailing.RandomTest;

@CrossOrigin("*")
@RestController
public class AccountRestController {
	
   @Autowired
   private AccountServices accountService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	
	@PostMapping("/register")
	public AppUser saveUser(@RequestBody RegisterForm registerForm) {
		
		if(!registerForm.getPassword().equals(registerForm.getRepassword()))
			throw new RuntimeException("Vous devez confirmer votre mot de passe");
		System.out.println(registerForm.getUsername());
		AppUser user = accountService.findByUsername(registerForm.getUsername());
		if(user!= null)
			throw new RuntimeException("ce utilisteur existe déjà ");
		AppUser appUser= new AppUser();
		appUser.setUsername(registerForm.getUsername());
		appUser.setEmail(registerForm.getEmail());
		appUser.setPassword(registerForm.getPassword());
		appUser.setOldpassword(registerForm.getPassword());
		appUser.setPays(registerForm.getPays());
		appUser.setDepartement(registerForm.getDepartement());
		 accountService.saveUser(appUser);
		// accountService.addRoleToUser(userForm.getUsername(), "USER");
		return appUser;
	}
	
	@PostMapping("/registerRole")
	public AppRole saveRole(@RequestBody AppRole role) {
		return accountService.saveRole(role);
	}
 
	@PostMapping("/attribuate")
	public void addRoleToUser(String usermane, String roleName) {
		accountService.addRoleToUser(usermane, roleName);
	}
	
	@GetMapping("/user/{username}")
	public AppUser findByUsername(@PathVariable String username) {
		return accountService.findByUsername(username);
	}

	@GetMapping("/userList")
	public List<AppUser> getUserList() {
		return accountService.getUserList();
	}
	
	@GetMapping("/roleList")
	public List<AppRole> getRoleList() {
		return accountService.getRoleList();
	}
	
	@PostMapping("/addrole")
	public void addRoleToUser(@RequestBody AjouterRole ajouterole){
		accountService.addRoleToUser(ajouterole.getUsername(), ajouterole.getRoleName());
	}
	
	//SUPPRIMER
	
	@GetMapping("/userDelete/{username}")
	public String userDelete(@PathVariable String username) {
		
		 accountService.userDelete(username);
		 return (username + " a été Supprimé ");
		 
	}
	
	//MODIFIER LE NOM UTILISATEUR
	
	@RequestMapping(value="/modifierUtilisateur/{username}",method=RequestMethod.POST)
	public AppUser modifierUtilisateur(@PathVariable String username, @RequestBody RegisterForm newuser)
		
    {
		AppUser user = accountService.findByUsername(username);
		if(user== null)
			throw new RuntimeException("Cet utilisteur n'existe pas");
		user.setUsername(newuser.getUsername());
		//user.setPassword(newuser.getPassword());
		return accountService.updateUser(user);
	
	}
	
	//MODIFICATION DU MOT DE PASSE 
	
	@RequestMapping(value="/modifierMotdePasse",method=RequestMethod.POST)
	public String changerPassword(@RequestBody UserForm userForm)
	
	{
		return accountService.changerPassword(userForm);
	}
  
	//MODIFIER UN ROLE
	
	@RequestMapping(value="/modifierUserRole",method=RequestMethod.POST)
	public void modifierUtilisateur(@RequestBody RegisterFormModif info)
		
    {
		accountService.updateUserRole(info);
		
	}
	
	//SUPPRIMER UN ROLE
	
		@RequestMapping(value="/deleteUserRole",method=RequestMethod.POST)
		public void deleteUserEtRole(@RequestBody RegisterFormDelete info)
		
	    {
			accountService.deleteUserRole(info);
			
		}

		
	@Autowired
	private EmailService service;

	@PostMapping(value="/sendingEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model = new HashMap<>();
		//CODE A GENERER
		String Code = "a5mSH";
		model.put("Name", request.getName());
		model.put("location", "Abidjan, Côte d'ivoire");
		//MIS
		model.put("code", Code);
		return service.sendEmail(request, model);

	}
	
	@GetMapping(value="/verifuserinfos/{username}/{email:.+}")
	public MailResponse verifUserInfos (@PathVariable String username,@PathVariable String email) {
		
		MailRequest mailBody = accountService.verifuserinfos(username, email);
		Map<String, Object> model = new HashMap<>();
		//CODE A GENERER
		RandomTest newpass = new RandomTest();
		String Code = newpass.random(5);
		model.put("Name", mailBody.getName());
		model.put("location", "Abidjan, Côte d'ivoire");
		
		AppUser user = accountService.findByUsername(mailBody.getName());
		String resultat = accountService.reinitialiserPassword(user, Code);
		System.out.println(mailBody.getFrom());
		model.put("code",Code);
		return service.sendEmail(mailBody, model);
		
		
	}
	
	@Autowired
	private AuditUserRepository auditR;
 
	@PostMapping(value="/sendTrace")
	public void  traceAction(@RequestBody AuditRegister req) {
	 AuditUser audit = new AuditUser();
	 AppUser user = accountService.findByUsername(req.getUser());
	 if (user==null) {
		 user = accountService.findByUsername("Intru");
	 }
	 audit.setUser(user);
	 audit.setAction(req.getAction());
	 audit.setActionDate(req.getActionDate());
	 audit.setStatut(req.getStatut());
	 auditR.save(audit);
	 System.out.println(" audit : "+ req.toString());
	}
	
	
	@CrossOrigin("*")
	@GetMapping(value="/TraceListe")
	public List<AuditUser> TraceListe(){
	List<AuditUser> audit = auditR.findAll();
		return audit;
}

}
