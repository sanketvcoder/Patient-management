package com.sanket.patient_management.controller.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.patient_management.DTO.PatientResponseDTO;
import com.sanket.patient_management.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PaitentControllerImpl {

    private final PatientService patientService;

    public PaitentControllerImpl(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }
}
