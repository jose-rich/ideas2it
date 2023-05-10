package com.i2it.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReferenceDto implements Serializable {

    private long referenceId;
    private String name;
    private String email;
    private long mobileNumber;
}
