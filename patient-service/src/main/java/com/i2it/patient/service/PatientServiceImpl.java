package com.i2it.patient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.i2it.patient.dto.PaginatedPatientResponse;
import com.i2it.patient.dto.PatientDto;
import com.i2it.patient.entity.PatientEntity;
import com.i2it.patient.mapper.PatientMapper;
import com.i2it.patient.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

	Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

	private final PatientRepository patientRepository;
	private final PatientMapper patientMapper;


	@Override
	public PatientDto addPatient(PatientDto patientDto) {
		if (Objects.nonNull(patientDto)) {
			PatientEntity patientEntity = patientMapper.toPatientEntity(patientDto);
			PatientEntity updatedPatientEntity = patientRepository.save(patientEntity);

			return patientMapper.toPatientDto(updatedPatientEntity);
		}
		logger.error("Error in Addition of new record - Empty Record Can't be Added");
		return null;
	}

	@Override
	public PaginatedPatientResponse getAllPatients(Pageable pageable) {
		Page<PatientEntity> patientEntities = patientRepository.findAll(pageable);
		return PaginatedPatientResponse.builder().numberOfItems(patientEntities.getTotalElements())
				.numberOfPages(patientEntities.getTotalPages())
				.patientDtoList(patientMapper.toPatientDtoList(patientEntities.getContent()))
				.build();
	}

	/*@Override
	public List<PatientDto> getAllPatients() {
		List<PatientEntity> patientEntityList = patientRepository.findAll();
		if (CollectionUtils.isEmpty(patientEntityList)) {
			return new ArrayList<>();
		} else {
			return patientMapper.toPatientDtoList(patientEntityList);
		}
	}*/

	@Override
	public PatientDto getPatientDetailsById(long pId) {
		Optional<PatientEntity> optionalPatientDetails = patientRepository.findById(pId);
		if (optionalPatientDetails.isPresent() && !optionalPatientDetails.isEmpty()) {
			PatientEntity patientEntity = optionalPatientDetails.get();
			return patientMapper.toPatientDto(patientEntity);
		} else {
			return null;
		}
	}

	@Override
	public PatientDto updatePatientDetails(PatientDto patientDto) {
		if (Objects.nonNull(patientDto)) {
			PatientEntity patientEntity = patientMapper.toPatientEntity(patientDto);
			PatientEntity existingPatientEntity = patientRepository.findById(patientEntity.getPatientId()).orElse(null);
			if (Objects.nonNull(existingPatientEntity)) {
				existingPatientEntity = patientMapper.fromPatientEntityToEntity(patientEntity);

			}
			return patientMapper.toPatientDto(patientRepository.save(existingPatientEntity));
		}
		logger.error("Error in Addition of new record - Empty Record Can't be Updated");
		return null;
	}

	@Override
	public String deletePatientDetails(long pId) {
		try {
			Optional<PatientEntity> existingRecord = patientRepository.findById(pId);
			if (existingRecord.isPresent() && !existingRecord.isEmpty()) {
				patientRepository.deleteById(pId);
			} else {
				return "Record with Patient Id " + pId + " is not found for Deletion";
			}
		} catch (Exception exception) {
			logger.error("Error in Deletion of the record with Patient Id " + pId + StringUtils.EMPTY + exception);
			return "Record with Patient Id  " + pId + "is not Deleted";
		}

		return "Record with Patient Id " + pId + " Deleted Successfully!!!";
	}

	@Override
	public List<String> getAllPatientsNameByAge(int age) {
		return patientRepository.getAllPatientsNameByAge(age);
	}

	@Override
	public List<PatientDto> getAllPatientsByName(String firstName, String lastName) {
		List<PatientEntity> patientEntityList = patientRepository.getPatientInfoByName(firstName, lastName);
		if (CollectionUtils.isEmpty(patientEntityList)) {
			return new ArrayList<>();
		} else {
			return patientMapper.toPatientDtoList(patientEntityList);
		}
	}

}
