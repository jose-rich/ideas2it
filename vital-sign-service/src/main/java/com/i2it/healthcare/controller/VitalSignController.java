package com.i2it.healthcare.controller;

import java.util.Date;
import java.util.List;

import com.i2it.healthcare.dto.PatientDto;
import com.i2it.healthcare.dto.VitalSignDto;
import com.i2it.healthcare.service.VitalSignService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "CRUD REST APIs for Vital Sign Resource",description = "CRUD REST APIs - Create Vital Sign, Update Vital, Get Vital, Get All Vital, Delete Vital")

@RestController
@RequestMapping("/vitalsign")
@CrossOrigin
@RequiredArgsConstructor
public class VitalSignController {

	private final VitalSignService vitalSignService;

	/**
	 * addCheckupDetails method is used to register new check up Details.
	 * 
	 * @param vitalSignDto
	 * @return String
	 */
	@PostMapping("/")
	@Operation(summary = "Insert New Vital Sign Detail of the Patient", description = "Insert New Vital Sign Detail of the Patient")
	public VitalSignDto addCheckupDetails(@RequestBody VitalSignDto vitalSignDto) {
		return vitalSignService.addCheckupDetails(vitalSignDto);
	}

	/**
	 * getCheckupDetails method is used to return check up Details.
	 * 
	 * @return VitalSignDto List
	 */
	@GetMapping("/")
	@Operation(summary = "Fetch CheckUp Details of the Patient by passing Patient Id and CheckUp date")
	public List<VitalSignDto> getCheckupDetails() {
		return vitalSignService.getCheckupDetails();
	}

	/**
	 * getCheckupDetails method is used to return check up Details based on patient
	 * Id and check up Date.
	 * 
	 * @param pId
	 * @param check up date
	 * @return VitalSignDto
	 */
	@GetMapping("/{pId}/{date}")
	@Operation(summary = "Fetch CheckUp Details of the Patient by passing Patient Id and CheckUp date")
	public VitalSignDto getCheckupDetails(@PathVariable long pId,
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		return vitalSignService.getCheckupDetails(pId, date);
	}

	/**
	 * getPatientDetails method is used to return check up Details of patient based
	 * on patient Id.
	 * 
	 * @param pId
	 * @return PatientDto
	 */
	@GetMapping("/patients/{pId}")
	@Operation(summary = "Fetch Details of the Patient by passing Patient Id")
	public PatientDto getPatientDetails(@PathVariable long pId) {
		return vitalSignService.getPatientDetails(pId);
	}

	/**
	 * updateVitalSigns method is used to update check up Details of patient based
	 * on patient Id and check up date.
	 * 
	 * @param pId
	 * @param check up date
	 * @param vital Sign values
	 * @return String
	 */
	@PutMapping("/{pId}/{date}/")
	@Operation(summary = "Update CheckUp Details of the Patient by passing Patient Id and CheckUp date")
	public VitalSignDto updateVitalSigns(@PathVariable long pId,
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestBody VitalSignDto vitalSignDto) {
		return vitalSignService.updateVitalSign(pId, date, vitalSignDto);
	}

	/**
	 * deleteCheckup method is used to delete check up Details of patient based on
	 * patient Id and check up date.
	 * 
	 * @param pId
	 * @param check up date
	 * @return String
	 */
	@DeleteMapping("/{pId}/{date}")
	@Operation(summary = "Delete CheckUp Details of the Patient by passing Patient Id and CheckUp date")
	public String deleteCheckup(@PathVariable long pId,
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		return vitalSignService.deleteCheckup(pId, date);
	}
}
