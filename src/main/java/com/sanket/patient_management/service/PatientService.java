package com.sanket.patient_management.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sanket.patient_management.ExceptionHandler.ElementNotFoundById;
import com.sanket.patient_management.ExceptionHandler.EmailAlreadyExistsException;
import com.sanket.patient_management.dto.PatientRequestDTO;
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
        return patients.stream()
                .map(PatientMapper::toDTO)
                .toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) throws EmailAlreadyExistsException {
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + patientRequestDTO.getEmail());
        }
        Patient p = PatientMapper.toEntity(patientRequestDTO);
        Patient newPatient = patientRepository.save(p);
        return PatientMapper.toDTO(newPatient);
    }

    public PatientResponseDTO updatePatientById(UUID id, PatientRequestDTO patientRequestDTO) {
        UUID patientId = id;
        Patient existing = patientRepository.findById(patientId)
                .orElseThrow(() -> new ElementNotFoundById("Patient not found with id: " + id));
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            // update fields
            existing.setName(patientRequestDTO.getName());
            existing.setEmail(patientRequestDTO.getEmail());
            existing.setAddress(patientRequestDTO.getAddress());
            existing.setDateOfBirth(java.time.LocalDate.parse(patientRequestDTO.getDateOfBirth()));
            existing.setDateOfRegistration(java.time.LocalDate.parse(patientRequestDTO.getRegisteredDate()));

        }

        Patient updated = patientRepository.save(existing);
        return PatientMapper.toDTO(updated);
    }
}
