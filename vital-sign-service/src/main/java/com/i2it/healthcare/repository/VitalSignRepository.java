package com.i2it.healthcare.repository;

import java.util.Date;
import java.util.List;

import com.i2it.healthcare.entity.VitalSignEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VitalSignRepository extends JpaRepository<VitalSignEntity, Long> {

	VitalSignEntity findByPatientIdAndCheckupDate(long pId, Date checkupDate);

	List<VitalSignEntity> findByPatientId(long pId);
}
