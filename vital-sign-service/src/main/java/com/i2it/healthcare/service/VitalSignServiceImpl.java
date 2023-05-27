package com.i2it.healthcare.service;

import com.i2it.healthcare.Client.PatientClient;
import com.i2it.healthcare.dto.PatientDto;
import com.i2it.healthcare.dto.VitalSignDto;
import com.i2it.healthcare.entity.VitalSignEntity;
import com.i2it.healthcare.mapper.VitalSignMapper;
import com.i2it.healthcare.repository.VitalSignRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VitalSignServiceImpl implements VitalSignService {

	private final VitalSignRepository vitalSignRepository;

	private final PatientClient patientClient;
	private final VitalSignMapper vitalSignMapper;

	Logger logger = LoggerFactory.getLogger(VitalSignServiceImpl.class);

	Consumer<String> errorConsumer = exception -> logger.error(exception);

	@Override
	public VitalSignDto addCheckupDetails(VitalSignDto vitalSignDto) {
		if (Objects.nonNull(vitalSignDto)) {
			VitalSignEntity vitalSignEntity = vitalSignMapper.toVitalSignEntity(vitalSignDto);
			return vitalSignMapper.toVitalSignDto(vitalSignRepository.save(vitalSignEntity));
		}
		errorConsumer.accept("Error in Addition of new record - Empty Record Can't be Added");
		return null;
	}

	@Override
	public VitalSignDto getCheckupDetails(long pId, Date checkUpDate) {
		VitalSignEntity vitalSignEntity = vitalSignRepository.findByPatientIdAndCheckupDate(pId, checkUpDate);
		if (Objects.nonNull(vitalSignEntity)) {
			return vitalSignMapper.toVitalSignDto(vitalSignEntity);
		} else {
			return null;
		}
	}

	@Override
	public VitalSignDto updateVitalSign(long pId, Date checkUpDate, VitalSignDto vitalSignDto) {
		if (Objects.nonNull(vitalSignDto)) {
			VitalSignEntity vitalSignEntity = vitalSignMapper.toVitalSignEntity(vitalSignDto);
			return vitalSignMapper
					.toVitalSignDto(updateVitalSign(pId, checkUpDate, vitalSignEntity));
		}
		errorConsumer.accept("Error in Updation of the record - Empty Record Can't be Updated");
		return null;
	}

	private VitalSignEntity updateVitalSign(long pId, Date checkUpDate, VitalSignEntity vitalSignEntity) {
		try {
			VitalSignDto existingVitalSignDto = getCheckupDetails(pId, checkUpDate);
			if (Objects.nonNull(existingVitalSignDto)) {
				return vitalSignRepository.save(vitalSignEntity);
			} else {
				errorConsumer.accept("No Record is found for Updation");
				return null;
			}
		} catch (Exception exception) {
			logger.error("Error in Updation of the record");
			errorConsumer.accept(exception.toString());
			return null;
		}
	}

	@Override
	public String deleteCheckup(long pId, Date checkUpDate) {
		try {
			VitalSignDto existingVitalSignDto = getCheckupDetails(pId, checkUpDate);
			if (Objects.nonNull(existingVitalSignDto)) {
				vitalSignRepository.deleteById(existingVitalSignDto.getCheckupId());
			} else {
				return "Record Not Found For Deletion.";
			}
		} catch (Exception exception) {
			logger.error("Error in Deletion of the record");
			errorConsumer.accept(exception.toString());
			return "Record not Deleted";
		}
		return "Record Deleted Successfully!!!";
	}

	@Override
	public PatientDto getPatientDetails(long pId) {
		return patientClient.getPatientDetailsById(pId);
	}

	@Override
	public List<VitalSignDto> getCheckupDetails() {
		{
			List<VitalSignEntity> vitalSignEntityList = vitalSignRepository.findAll();
			if (!CollectionUtils.isEmpty(vitalSignEntityList)) {
				return vitalSignEntityList.stream().map(vitalSignEntity -> {
					return vitalSignMapper.toVitalSignDto(vitalSignEntity);
				}).collect(Collectors.toList());
			} else {
				return null;
			}
		}
	}

}
