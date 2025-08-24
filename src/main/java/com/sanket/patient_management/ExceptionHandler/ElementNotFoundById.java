package com.sanket.patient_management.ExceptionHandler;

public class ElementNotFoundById extends RuntimeException {

    public ElementNotFoundById(String message) {
        super(message);
    }

}
