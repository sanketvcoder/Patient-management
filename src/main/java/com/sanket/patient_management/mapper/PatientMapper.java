package com.sanket.patient_management.mapper;

import java.time.LocalDate;
import com.sanket.patient_management.dto.PatientRequestDTO;
import com.sanket.patient_management.dto.PatientResponseDTO;
import com.sanket.patient_management.model.Patient;

public class PatientMapper {

    public static Patient toEntity(PatientRequestDTO dto) {
        Patient p = new Patient();
        p.setName(dto.getName());
        p.setEmail(dto.getEmail());
        p.setAddress(dto.getAddress());
        p.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));  // ✅ convert String -> LocalDate
        p.setDateOfRegistration(LocalDate.parse(dto.getRegisteredDate())); // ✅ convert String -> LocalDate
        return p;
    }

    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.setId(patient.getId().toString());
        dto.setName(patient.getName());
        dto.setEmail(patient.getEmail());
        dto.setAddress(patient.getAddress());
        dto.setDateOfBirth(patient.getDateOfBirth().toString());
        return dto;
    }
}
