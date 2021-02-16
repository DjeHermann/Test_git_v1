package com.osis.cipres.immatriculation.services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.osis.cipres.immatriculation.tables.*;
import com.osis.cipres.immatriculation.repositories.EmployeurRepository;

@CrossOrigin("*")
@RestController
public class EmployeurController {
	
	@Autowired
	EmployeurRepository employeurRepository;
	
	@GetMapping("/employeurList")
	public List<Ima_dim_employeur> getEmployeurList(){
		return employeurRepository.findCentFirst(PageRequest.of(0,100));
	}
	
	@GetMapping("/employeurPages")
	public ResponseEntity<Map<String,Object>> getAllemployeur(
			 @RequestParam(defaultValue = "0") int page,
		        @RequestParam(defaultValue = "1000") int size){
		
		try {
		      List<Ima_dim_employeur> employeurs = new ArrayList<Ima_dim_employeur>();
		      Pageable paging = PageRequest.of(page, size);
		      
		      Page<Ima_dim_employeur> pageEmp;
	
		        pageEmp = employeurRepository.findAll(paging);
		        
		        employeurs = pageEmp.getContent();
		        
		        Map<String, Object> response = new HashMap<>();
		        response.put("body", employeurs);
		        response.put("currentPage", pageEmp.getNumber());
		        response.put("totalItems", pageEmp.getTotalElements());
		        response.put("totalPages", pageEmp.getTotalPages());

		        return new ResponseEntity<>(response, HttpStatus.OK);
		      } catch (Exception e) {
		        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		      }
			
	} 
}
