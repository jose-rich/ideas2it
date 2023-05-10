package com.i2it.patient.controller;

import com.i2it.patient.dto.PaginatedPatientResponse;
import com.i2it.patient.dto.PatientDto;
import com.i2it.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/patients")
public class PatientController {

	private final PatientService patientService;

	@PostMapping("/")
	public PatientDto addNewPatient(@RequestBody PatientDto patientDto) {
		return patientService.addPatient(patientDto);
	}

	@GetMapping("/")
	public PaginatedPatientResponse getAllPatients(Pageable pageable) {
		return patientService.getAllPatients(pageable);
	}

	@GetMapping("/age")
	public List<String> getAllPatientsNameByAge(@RequestParam int age) {
		return patientService.getAllPatientsNameByAge(age);
	}

	@GetMapping("/{firstName}/{lastName}")
	public List<PatientDto> getAllPatientsByName(@PathVariable String firstName, @PathVariable String lastName) {
		return patientService.getAllPatientsByName(firstName, lastName);
	}

	@GetMapping("/{pId}")
	public PatientDto getPatientDetailsById(@PathVariable long pId) {
		PatientDto pDto = patientService.getPatientDetailsById(pId);
		return pDto;
	}

	@PutMapping("/")
	public PatientDto updatePatientDetails(@RequestBody PatientDto patientDto) {
		return patientService.updatePatientDetails(patientDto);
	}

	@DeleteMapping("/{pId}")
	public String deletePatientDetails(@PathVariable long pId) {
		return patientService.deletePatientDetails(pId);
	}
}
