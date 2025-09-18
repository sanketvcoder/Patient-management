package com.sanket.patient_management.mapper;

import com.sanket.patient_management.DTO.PatientRequestDTO;
import com.sanket.patient_management.DTO.PatientResponseDTO;
import com.sanket.patient_management.model.Patient;

public class PatientMapper {

    // Convert Entity → DTO
    public static PatientResponseDTO toDTO(Patient patient) {
        if (patient == null) {
            return null;
        }
        return new PatientResponseDTO(
                patient.getId().toString(),
                patient.getName(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getDate_of_birth().toString()
        );
    }

    // Convert DTO → Entity
    public static Patient toEntity(PatientRequestDTO patientDTO) {
        if (patientDTO == null) {
            return null;
        }
        return new Patient(
                null, // id → handled by DB
                patientDTO.getName(),
                patientDTO.getEmail(),
                patientDTO.getAddress(),
                java.time.LocalDate.parse(patientDTO.getDate_of_birth()),
                java.time.LocalDate.now()
        );
    }
}
