
package com.i2it.healthcare.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataDto {

	private List<String> fieldName;
	private List<Object> oldValue;
	private List<Object> newValue;
}