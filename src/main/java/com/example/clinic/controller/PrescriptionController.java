package com.example.clinic.controller;

import com.example.clinic.domain.Prescription;
import com.example.clinic.service.PrescriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
