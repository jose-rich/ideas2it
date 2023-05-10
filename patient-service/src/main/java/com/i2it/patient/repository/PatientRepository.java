package com.i2it.patient.repository;

import java.util.List;

import com.i2it.patient.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

	List<String> getAllPatientsNameByAge(int age);

	List<PatientEntity> getPatientInfoByName(String firstName, String Lastname);

}
