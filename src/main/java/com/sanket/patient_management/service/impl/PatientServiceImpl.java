package com.sanket.patient_management.service.impl;

import java.util.List;

import com.sanket.patient_management.DTO.PatientResponseDTO;
import com.sanket.patient_management.model.Patient;
import com.sanket.patient_management.repository.PatientRepository;
import com.sanket.patient_management.service.PatientService;

public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patient -> new PatientResponseDTO(
                patient.getId().toString(),
                patient.getName(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getDate_of_birth() != null ? patient.getDate_of_birth().toString() : null
        )).toList();

    }

}
