package com.sanket.patient_management.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sanket.patient_management.DTO.PatientRequestDTO;
import com.sanket.patient_management.DTO.PatientResponseDTO;
import com.sanket.patient_management.Exception.EmailAlreadyExistsException;
import com.sanket.patient_management.Exception.PatientNotFoundException;
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

    @Override
    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientDTO) {
        Patient existPatient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id : " + id));
        if (!existPatient.getEmail().equals(patientDTO.getEmail()) && patientRepository.existsByEmail(patientDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists with email : " + patientDTO.getEmail());
        }
        existPatient.setName(patientDTO.getName());
        existPatient.setEmail(patientDTO.getEmail());
        existPatient.setAddress(patientDTO.getAddress());
        existPatient.setDate_of_birth(patientDTO.getRegistered_date() != null ? LocalDate.parse(patientDTO.getDate_of_birth()) : LocalDate.now());
        existPatient.setRegistered_date(patientDTO.getRegistered_date() != null ? LocalDate.parse(patientDTO.getRegistered_date()) : LocalDate.now());

        Patient p = patientRepository.save(existPatient);
        return PatientMapper.toDTO(p);

    }

}
