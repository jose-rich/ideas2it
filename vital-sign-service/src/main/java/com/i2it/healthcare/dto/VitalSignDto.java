package com.i2it.healthcare.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "VitalSignDto Model Information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VitalSignDto implements Serializable {

	private static final long serialVersionUID = 3640201391320286975L;

	@Schema(description = "Check Up Id of the Patient", name = "checkupId", required = true)
	private long checkupId;

	@Schema(description = "Unique Id of the Patient", name = "patientId", required = true)
	private long patientId;

	@Schema(description = "Date of the Checkup", name = "checkupDate", required = true)
	private Date checkupDate;

	@Schema(description = "Pulse Rate of the Patient on that Checkup date", name = "pulseRate", required = false)
	private float pulseRate;

	@Schema(description = "Blood Pressure of the Patient on that Checkup date", name = "bloodPressure", required = false)
	private float bloodPressure;

	@Schema(description = "Temperature of the Patient on that Checkup date", name = "temperature", required = false)
	private float temperature;

	@Schema(description = "Respiration Rate of the Patient on that Checkup date", name = "respirationRate", required = false)
	private float respirationRate;

	@Schema(description = "Blood Sugar Level of the Patient on that Checkup date", name = "bloodSugar", required = false)
	private float bloodSugar;

	@Schema(description = "Height of the Patient on that Checkup date", name = "height", required = false)
	private float height;

	@Schema(description = "Weight of the Patient on that Checkup date", name = "weight", required = false)
	private float weight;

	@Schema(description = "User who Created the entity", name = "createdBy", required = true)
	private String createdBy;

	private LocalDateTime createdAt;

	@Schema(description = "User who Updated the entity", name = "updatedBy", required = true)
	private String updatedBy;

	private LocalDateTime updateAt;

}
