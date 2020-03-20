package com.example.clinic.domain;

import com.example.clinic.domain.Doctor;
import com.example.clinic.domain.Patient;
import lombok.Data;

@Data
public class Prescription {

    private Long id;
    private Patient patient;
    private Doctor doctor;
    private String description;


}
