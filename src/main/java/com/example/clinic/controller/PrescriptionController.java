package com.example.clinic.controller;

import com.example.clinic.domain.Prescription;
import com.example.clinic.model.PrescriptionDTO;
import com.example.clinic.service.PrescriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping(value = "", produces = "application/json")
    public List<Prescription> showAllPrescriptions(){
        return prescriptionService.showAllPrescriptions();
    }

    @GetMapping(value = "/patient", produces = "application/json")
    public List<PrescriptionDTO> showAllPrescriptionsByPatient(@RequestParam String username){
        return prescriptionService.getPrescriptionsByPatient(username);
    }

    @PostMapping(value = "/prescription/add", consumes = "application/json")
    public ResponseEntity<Long> submitPrescription(@RequestBody Prescription prescription){
        return new ResponseEntity<>(prescriptionService.addPrescription(prescription), HttpStatus.CREATED);
    }
}
