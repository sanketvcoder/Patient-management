package com.sanket.patient_management.service.impl;

import java.util.List;

import com.sanket.patient_management.DTO.PatientResponseDTO;
import com.sanket.patient_management.model.Patient;
import com.sanket.patient_management.repository.PatientRepository;
import com.sanket.patient_management.service.PatientService;

public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patient -> new PatientResponseDTO(patient.getId(), patient.getName(), patient.getEmail(), patient.getAddress(), patient.getDate_of_birth().toString()))
                .toList();
    }

}
