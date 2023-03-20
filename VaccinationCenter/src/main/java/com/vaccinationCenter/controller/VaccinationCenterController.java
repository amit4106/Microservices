package com.vaccinationCenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vaccinationCenter.entity.VaccinationCenter;
import com.vaccinationCenter.model.Citizen;
import com.vaccinationCenter.model.RequiredResponse;
import com.vaccinationCenter.repository.VaccinationCenterRepository;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

	@Autowired
	private VaccinationCenterRepository centerRepository;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vaccinationCenter) {
		VaccinationCenter vaccinationCenterAdded = centerRepository.save(vaccinationCenter);
		return new ResponseEntity<>(vaccinationCenter, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<RequiredResponse> getAllDataBaseBasedOnId(@PathVariable("id") Integer id) {
		RequiredResponse requiredResponse = new RequiredResponse();
//		First get vaccination center details
		VaccinationCenter center = centerRepository.findById(id).get();
		requiredResponse.setCenter(center);

//		and than get all citizens registered to vaccination center

		List<Citizen> listOfCitizens = restTemplate.getForObject("http://localhost:8081/citizen/id/" + id, List.class);
		requiredResponse.setCitizens(listOfCitizens);

		return new ResponseEntity<>(requiredResponse, HttpStatus.OK);
	}

}
