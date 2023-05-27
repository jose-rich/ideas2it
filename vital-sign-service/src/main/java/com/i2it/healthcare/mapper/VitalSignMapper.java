package com.i2it.healthcare.mapper;

import com.i2it.healthcare.dto.VitalSignDto;
import com.i2it.healthcare.entity.VitalSignEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VitalSignMapper {

    VitalSignDto toVitalSignDto(VitalSignEntity vitalSignEntity);

    VitalSignEntity toVitalSignEntity (VitalSignDto VitalSignDto);

    List<VitalSignDto> toVitalSignDtoList(List<VitalSignEntity> vitalSignEntityList);

    List<VitalSignEntity> toVitalSignEntityList (List<VitalSignDto> VitalSignDtoList);


}
