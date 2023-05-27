package com.i2it.healthcare.Client;

import com.i2it.healthcare.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;
import java.util.function.Consumer;

@FeignClient(url = "${vitalsignmodule.patient.client.url}", name = "${vitalsignmodule.patient.client.name}")
@FunctionalInterface
public interface PatientClient {

	@GetMapping("/{pId}")
	public PatientDto getPatientDetailsById(@PathVariable long pId);
	
	default Consumer<String> andThen(Consumer<? super String> after) {
        Objects.requireNonNull(after);
        return null;
    }
	
	default Consumer<String> andThen1(Consumer<? super String> after) {
        Objects.requireNonNull(after);
        return null;
    }
}
