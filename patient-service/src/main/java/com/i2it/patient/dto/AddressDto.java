package com.i2it.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto implements Serializable {

    private long addressId;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private long mobileNumber;
    private String email;
}
