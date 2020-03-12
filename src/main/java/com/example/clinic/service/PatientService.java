package com.example.clinic.service;

import com.example.clinic.exception.DuplicateUsernameException;
import com.example.clinic.model.Patient;
import com.example.clinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public String addPatient(Patient patient) {

         patientRepository.findPatientByUsername(patient.getUsername())
                .ifPresent( patient1 -> throwDuplicateUsernameException(patient.getUsername()));

        patientRepository.save(patient);

        return patient.getUsername();

    }

    private void throwDuplicateUsernameException(String username) {
        throw new DuplicateUsernameException("Patient with username " + username + " already exists");
    }

    public void removePatientByUsername(String username) {
        patientRepository.deleteById(username);
    }
}
