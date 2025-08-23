package com.sanket.patient_management.mapper;

import com.sanket.patient_management.dto.PatientResponseDTO;
import com.sanket.patient_management.model.Patient;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient) {
        if (patient == null) {
            return null;
        }
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.setId(patient.getId().toString());
        dto.setName(patient.getName());
        dto.setEmail(patient.getEmail());
        dto.setAddress(patient.getAddress());
        dto.setDateOfBirth(patient.getDateOfBirth().toString());
        return dto;

    }
}
