package com.citizen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citizen.entity.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer>{

	public List<Citizen> findByVaccinationCenterId(Integer id);
}
