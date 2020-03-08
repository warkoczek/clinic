package com.example.clinic.model;

import lombok.Data;

@Data
public class Prescription {

    private Long id;
    private Patient patient;
    private Doctor doctor;
    private String description;


}
