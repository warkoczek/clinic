package com.example.clinic.controller;

import com.example.clinic.model.Patient;
import com.example.clinic.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/patients", produces = "application/json")
    public List<Patient> showAllPatients(){
        return patientService.retrieveAllPatients();
    }

    @GetMapping(value = "/patient", produces = "application/json")
    public ResponseEntity<Patient> showPatientByUsername(@RequestParam(required = false) String username){
        //return patientService.retrievePatientByUsername(username);
        Optional<Patient> patient = patientService.retrievePatientByUsername(username);
        if(!patient.isPresent()){
            System.out.println("Patient with username " + username + "does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(patient.get());
    }

    @PostMapping(value = "/patients/add", consumes = "application/json")
    public ResponseEntity<String> submitPatient(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.CREATED);
    }
}
