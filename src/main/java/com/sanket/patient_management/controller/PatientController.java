package com.sanket.patient_management.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.sanket.patient_management.DTO.PatientRequestDTO;
import com.sanket.patient_management.DTO.PatientResponseDTO;

public interface PatientController {

    ResponseEntity<List<PatientResponseDTO>> getAllPatients();

    ResponseEntity<PatientResponseDTO> createPatient(PatientRequestDTO patientDTO);

    ResponseEntity<PatientResponseDTO> updatePatient(UUID id, PatientRequestDTO patientDTO);

    ResponseEntity<String> getPatientById(UUID id);
}
