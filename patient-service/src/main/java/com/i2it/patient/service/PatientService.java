package com.i2it.patient.service;

import java.util.List;

import com.i2it.patient.dto.PaginatedPatientResponse;
import com.i2it.patient.dto.PatientDto;
import org.springframework.data.domain.Pageable;

public interface PatientService {

	PatientDto addPatient(PatientDto patientDto);

	PaginatedPatientResponse getAllPatients(Pageable pageable);

	PatientDto getPatientDetailsById(long pId);

	PatientDto updatePatientDetails(PatientDto patientDto);

	String deletePatientDetails(long pId);

	List<String> getAllPatientsNameByAge(int age);

	List<PatientDto> getAllPatientsByName(String firstName, String lastName);

}
