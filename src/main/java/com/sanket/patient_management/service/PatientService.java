package com.sanket.patient_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sanket.patient_management.dto.PatientResponseDTO;
import com.sanket.patient_management.mapper.PatientMapper;
import com.sanket.patient_management.model.Patient;
import com.sanket.patient_management.repository.PatientRepository;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOs = patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();
        return patientResponseDTOs;
    }
}
