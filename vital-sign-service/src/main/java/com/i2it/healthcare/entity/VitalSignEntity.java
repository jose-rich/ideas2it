package com.i2it.healthcare.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vitalsign")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VitalSignEntity implements Serializable {

	private static final long serialVersionUID = 6313577177732488030L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vital_sign_id_generator")
	@SequenceGenerator(initialValue = 1, allocationSize = 100, name = "vital_sign_id_generator")
	@Column(name = "checkup_id")
	@Schema(description ="Check Up Id of the Patient", name = "checkupId", required = true)
	private long checkupId;

	@Column(name = "patient_id")
	@Schema(description ="Unique Id of the Patient", name = "patientId", required = true)
	private long patientId;

	@Column(name = "checkup_date")
	@Schema(description ="Date of the Checkup", name = "checkupDate", required = true)
	private Date checkupDate;

	@Column(name = "pulse_rate")
	@Schema(description ="Pulse Rate of the Patient on that Checkup date", name = "pulseRate", required = false)
	private float pulseRate;

	@Column(name = "blood_pressure")
	@Schema(description ="Blood Pressure of the Patient on that Checkup date", name = "bloodPressure", required = false)
	private float bloodPressure;

	@Column(name = "temperature")
	@Schema(description ="Temperature of the Patient on that Checkup date", name = "temperature", required = false)
	private float temperature;

	@Column(name = "respiration_rate")
	@Schema(description ="Respiration Rate of the Patient on that Checkup date", name = "respirationRate", required = false)
	private float respirationRate;

	@Column(name = "blood_sugar")
	@Schema(description ="Blood Sugar Level of the Patient on that Checkup date", name = "bloodSugar", required = false)
	private float bloodSugar;

	@Column(name = "height")
	@Schema(description ="Height of the Patient on that Checkup date", name = "height", required = false)
	private float height;

	@Column(name = "weight")
	@Schema(description ="Weight of the Patient on that Checkup date", name = "weight", required = false)
	private float weight;

	@CreatedBy
	@Column(name = "created_by")
	@Schema(description ="User who Created the entity", name = "createdBy", required = true)
	private String createdBy;

	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@LastModifiedBy
	@Column(name = "updated_by")
	@Schema(description ="User who Updated the entity", name = "updatedBy", required = false)
	private String updatedBy;

	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updateAt;
}
