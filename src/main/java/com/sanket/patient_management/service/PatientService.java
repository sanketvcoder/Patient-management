package com.sanket.patient_management.service;

import org.springframework.stereotype.Service;

import com.sanket.patient_management.repository.PatientRepository;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
}
