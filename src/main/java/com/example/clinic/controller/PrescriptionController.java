package com.example.clinic.controller;

import com.example.clinic.domain.Prescription;
import com.example.clinic.model.PrescriptionDTO;
import com.example.clinic.service.PrescriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/prescriptions/prescription")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping(value = "/prescriptions", produces = "application/json")
    public List<Prescription> showAllPrescriptions(){
        return prescriptionService.showAllPrescriptions();
    }

    @GetMapping(value = "/patient", produces = "application/json")
    public List<PrescriptionDTO> showAllPrescriptionsByPatient(@RequestParam String username){
        return prescriptionService.getPrescriptionsByPatient(username);
    }
    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<PrescriptionDTO> showPrescriptionById(@RequestParam Long id){

        Optional<PrescriptionDTO> prescription = prescriptionService.getPrescriptionById(id);

        return prescription.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<Long> submitPrescription(@RequestBody Prescription prescription){
        return new ResponseEntity<>(prescriptionService.addPrescription(prescription), HttpStatus.CREATED);
    }
}
