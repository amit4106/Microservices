package com.vaccinationCenter.model;

import java.util.List;

import com.vaccinationCenter.entity.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequiredResponse {

	private VaccinationCenter center;
	private List<Citizen> citizens;
	
}
