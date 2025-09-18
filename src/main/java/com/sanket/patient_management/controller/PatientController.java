package com.sanket.patient_management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sanket.patient_management.DTO.PatientRequestDTO;
import com.sanket.patient_management.DTO.PatientResponseDTO;

public interface PatientController {

    ResponseEntity<List<PatientResponseDTO>> getAllPatients();

    ResponseEntity<PatientResponseDTO> createPatient(PatientRequestDTO patientDTO);
}
