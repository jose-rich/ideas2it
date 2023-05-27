package com.i2it.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhysicianDtlDto implements Serializable {

    private long physicianId;
    private String name;
    private String email;
    private long mobileNumber;
}
