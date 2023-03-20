package com.citizen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizen.entity.Citizen;
import com.citizen.repository.CitizenRepository;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

	@Autowired
	private CitizenRepository citizenRepository;

	@RequestMapping("/get")
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("hello", HttpStatus.OK);
	}

	@RequestMapping("/id/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id) {
		List<Citizen> listCitizen = citizenRepository.findByVaccinationCenterId(id);
		return new ResponseEntity<>(listCitizen, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen) {
		Citizen citizen = citizenRepository.save(newCitizen);
		return new ResponseEntity<>(citizen, HttpStatus.OK);
	}

}
