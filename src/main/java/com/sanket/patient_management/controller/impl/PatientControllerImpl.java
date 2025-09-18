package com.sanket.patient_management.controller.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.patient_management.DTO.PatientRequestDTO;
import com.sanket.patient_management.DTO.PatientResponseDTO;
import com.sanket.patient_management.controller.PatientController;
import com.sanket.patient_management.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patients")
public class PatientControllerImpl implements PatientController {

    private final PatientService patientService;

    public PatientControllerImpl(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    @Override
    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientDTO) {
        return ResponseEntity.ok().body(patientService.createPatient(patientDTO));
    }

}
