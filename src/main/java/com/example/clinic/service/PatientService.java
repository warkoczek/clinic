package com.example.clinic.service;

import com.example.clinic.model.Patient;
import com.example.clinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientService  {

    private final PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public List<Patient> retrieveAllPatients(){
        return patientRepository.findAll();
    }

    public Optional<Patient> retrievePatientByUsername(String username){

        return patientRepository.findPatientByUsername(username);
    }




}
