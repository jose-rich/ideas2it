package com.i2it.healthcare.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditDto implements Serializable {

	private static final long serialVersionUID = 4357699966419669088L;

	private String userName;

	private String serviceName;

	private String methodName;

	private String request;

	private DataDto data;

	private String action;

	private String logDate;

	private String logTime;

}
