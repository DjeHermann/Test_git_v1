package com.osis.cipres.immatriculation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osis.cipres.immatriculation.repositories.GroupeAgeRepository;
import com.osis.cipres.immatriculation.tables.Ima_dim_groupe_age;

@CrossOrigin("*")
@RestController
public class GroupeAgeController {
@Autowired
private GroupeAgeRepository groupeAgeRepository;

@GetMapping("/groupeAgeList")
public List<Ima_dim_groupe_age> getListGroupeAge(){
	return groupeAgeRepository.findAllOrderByCle();
}
}
