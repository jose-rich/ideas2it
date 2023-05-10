package com.i2it.patient.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.i2it.patient.entity.AddressEntity;
import com.i2it.patient.entity.PhysicianDtlEntity;
import com.i2it.patient.entity.ReferenceEntity;
import com.i2it.patient.util.DiagonosesLevel;
import com.i2it.patient.util.PatientStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto implements Serializable {

	private static final long serialVersionUID = -6303297266361893838L;

	private long patientId;

	private String firstName;

	private String lastName;

	private LocalDate dob;

	private String gender;

	private Integer age;

	private String maritalStatus;

	private LocalDateTime initialAdmitDate;

	private Boolean isInsured;

	@Enumerated(EnumType.STRING)
	private PatientStatus status;

	@Enumerated(EnumType.STRING)
	private DiagonosesLevel diagonosesLevel;

	@OneToOne
	private AddressDto address;

	@ManyToOne
	private ReferenceDto reference;

	@ManyToOne
	private PhysicianDtlDto physicianDtl;

}
