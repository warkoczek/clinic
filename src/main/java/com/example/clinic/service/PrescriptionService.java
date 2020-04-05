package com.example.clinic.service;

import com.example.clinic.domain.Prescription;
import com.example.clinic.exception.PrescriptionNotFoundException;
import com.example.clinic.model.PrescriptionDTO;
import com.example.clinic.model.dto.PrescriptionDTOInterface;
import com.example.clinic.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PrescriptionService {


    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public List<Prescription> showAllPrescriptions(){
        return prescriptionRepository.findAll();
    }

    public Optional<PrescriptionDTO> getPrescriptionById(Long id){
        Optional<Prescription> prescription = prescriptionRepository.findPrescriptionById(id);
        return prescription.map(value -> PrescriptionDTOInterface.getTypeMap().map(value));
    }

    public List<PrescriptionDTO> getPrescriptionsByPatient(String username){

        return prescriptionRepository.findPrescriptionsByPatient_Username(username).stream()
                .map(prescription -> PrescriptionDTOInterface.getTypeMap().map(prescription))
                .sorted(Comparator.comparing(PrescriptionDTO::getPrescriptionIssueDate))
                .collect(Collectors.toList());
    }


    public Long addPrescription(Prescription prescription){
        prescriptionRepository.save(prescription);
        return prescription.getId();
    }


    public Prescription dispenseMedicine(Long id) {

        Prescription prescriptionToDispenseMedicineFrom =
                prescriptionRepository.findPrescriptionById(id).orElseThrow(() ->
        new PrescriptionNotFoundException("Prescription with this id does not exist "));
        if(prescriptionToDispenseMedicineFrom.isPrescriptionValid()) {
            prescriptionToDispenseMedicineFrom.setMedicineDispenseDate(LocalDateTime.now());
            prescriptionRepository.save(prescriptionToDispenseMedicineFrom);
        }else{
            System.out.println("Prescription not valid");
        }
        return prescriptionToDispenseMedicineFrom;

    }
}
