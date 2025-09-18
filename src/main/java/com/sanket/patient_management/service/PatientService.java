package com.sanket.patient_management.service;

import java.util.List;
import java.util.UUID;

import com.sanket.patient_management.DTO.PatientRequestDTO;
import com.sanket.patient_management.DTO.PatientResponseDTO;

public interface PatientService {

    List<PatientResponseDTO> getAllPatients();

    PatientResponseDTO createPatient(PatientRequestDTO patientDTO);

    PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientDTO);

}
