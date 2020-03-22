package com.example.clinic.service;

import com.example.clinic.domain.Prescription;
import com.example.clinic.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public List<Prescription> showAllPrescriptions(){
        return prescriptionRepository.findAll();
    }

    public Set<Prescription> showPrescriptionsByPatient(String username){
        return  prescriptionRepository.findPrescriptionsByPatient_Username(username);
    }
}
