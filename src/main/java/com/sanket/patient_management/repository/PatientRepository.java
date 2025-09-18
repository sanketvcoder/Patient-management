package com.sanket.patient_management.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.patient_management.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

}
