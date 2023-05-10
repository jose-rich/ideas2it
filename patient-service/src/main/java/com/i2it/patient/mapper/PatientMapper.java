package com.i2it.patient.mapper;

import com.i2it.patient.dto.PatientDto;
import com.i2it.patient.entity.PatientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDto toPatientDto(PatientEntity entity);

    PatientEntity toPatientEntity (PatientDto dto);

    List<PatientDto> toPatientDtoList(List<PatientEntity> entityList);

    List<PatientEntity> toPatientEntityList (List<PatientDto> dtoList);

    @Mapping(target = "patientId", ignore = true)
    @Mapping(target = "initialAdmitDate", ignore = true)
    @Mapping(target = "status", ignore = true)
    PatientEntity fromPatientEntityToEntity (PatientEntity entity);




}
