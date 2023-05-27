package com.i2it.healthcare.service;

import com.i2it.healthcare.dto.PatientDto;
import com.i2it.healthcare.dto.VitalSignDto;

import java.util.Date;
import java.util.List;

public interface VitalSignService {

	VitalSignDto addCheckupDetails(VitalSignDto vitalSignDto);

	VitalSignDto getCheckupDetails(long pId, Date date);

	VitalSignDto updateVitalSign(long pId, Date date, VitalSignDto vitalSignDto);

	String deleteCheckup(long pId, Date date);

	PatientDto getPatientDetails(long pId);

	List<VitalSignDto> getCheckupDetails();

}
