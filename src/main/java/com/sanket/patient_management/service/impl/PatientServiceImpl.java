package com.sanket.patient_management.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sanket.patient_management.DTO.PatientRequestDTO;
import com.sanket.patient_management.DTO.PatientResponseDTO;
import com.sanket.patient_management.Exception.EmailAlreadyExistsException;
import com.sanket.patient_management.mapper.PatientMapper;
import com.sanket.patient_management.model.Patient;
import com.sanket.patient_management.repository.PatientRepository;
import com.sanket.patient_management.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patient -> PatientMapper.toDTO(patient)).toList();
    }

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO patientDTO) {
        if (patientRepository.existsByEmail(patientDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists with email : " + patientDTO.getEmail());
        }
        Patient patient = PatientMapper.toEntity(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return PatientMapper.toDTO(savedPatient);
    }

}
