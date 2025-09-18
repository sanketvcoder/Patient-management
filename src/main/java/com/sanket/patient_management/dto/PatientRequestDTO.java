package com.sanket.patient_management.DTO;

import com.sanket.patient_management.DTO.validators.CreatePatientValidationGroup;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

    @NotBlank
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Size(message = "Email Should be valid and cannot exceed 15 characters")
    private String email;

    @NotBlank(message = "Address is mandatory")
    @Size(message = "Address cannot exceed 200 characters")
    private String address;

    @NotBlank(message = "Date of Birth is mandatory")
    private String date_of_birth;

    @NotBlank(groups = CreatePatientValidationGroup.class, message = "Registered Date is mandatory")
    private String registered_date;

    public PatientRequestDTO() {
    }

    public PatientRequestDTO(@NotBlank @Size(max = 100, message = "Name cannot exceed 100 characters") String name,
            @NotBlank(message = "Email is mandatory") @Size(message = "Email Should be valid and cannot exceed 15 characters") String email,
            @NotBlank(message = "Address is mandatory") @Size(message = "Address cannot exceed 200 characters") String address,
            @NotBlank(message = "Date of Birth is mandatory") String date_of_birth,
            @NotNull(message = "Registered Date is mandatory") String registered_date) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.date_of_birth = date_of_birth;
        this.registered_date = registered_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getRegistered_date() {
        return registered_date;
    }

    public void setRegistered_date(String registered_date) {
        this.registered_date = registered_date;
    }

}
