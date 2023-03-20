package com.vaccinationCenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citizen {

	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@Column
	private int vaccinationCenterId;
}
