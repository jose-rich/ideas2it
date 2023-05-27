package com.i2it.patient.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PaginatedPatientResponse {
    private List<PatientDto> patientDtoList;
    private Long numberOfItems;
    private int numberOfPages;
}
