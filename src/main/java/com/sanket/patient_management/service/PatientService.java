package com.sanket.patient_management.service;

import java.util.List;

import com.sanket.patient_management.DTO.PatientRequestDTO;
import com.sanket.patient_management.DTO.PatientResponseDTO;

public interface PatientService {

    List<PatientResponseDTO> getAllPatients();

    PatientResponseDTO createPatient(PatientRequestDTO patientDTO);

}
