package com.i2it.patient.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


import com.i2it.patient.util.DiagonosesLevel;
import com.i2it.patient.util.PatientStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries(value = {
		@NamedQuery(name = "PatientEntity.getAllPatientsNameByAge", query = "Select CONCAT(p.firstName, '_', p.lastName) From PatientEntity as p Where p.age = ?1 order by p.firstName"),
		@NamedQuery(name = "PatientEntity.getPatientInfoByName", query = "Select p From PatientEntity as p Where p.firstName = ?1 And p.lastName = ?2  order by p.firstName") })
@EntityListeners(AuditingEntityListener.class)
public class PatientEntity extends AuditEntity implements Serializable {

	private static final long serialVersionUID = -1660387656600048948L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private AddressEntity address;

	@ManyToOne
	private ReferenceEntity reference;

	@ManyToOne
	private PhysicianDtlEntity physicianDtl;

}
