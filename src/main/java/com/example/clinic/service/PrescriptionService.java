package com.example.clinic.service;

import com.example.clinic.domain.Dispense;
import com.example.clinic.domain.Prescription;
import com.example.clinic.domain.PrescriptionType;
import com.example.clinic.exception.PrescriptionNotFoundException;
import com.example.clinic.model.dto.prescription.PrescriptionDTO;
import com.example.clinic.model.dto.prescription.PrescriptionDTOInterface;
import com.example.clinic.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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


    public Optional<Dispense> dispenseMedicine(Long id) {

        Prescription dispensablePrescription = prescriptionRepository.findPrescriptionById(id).orElseThrow(() ->
                new PrescriptionNotFoundException("Prescription with this id does not exist"));

       /* Optional<Prescription> prescription = prescriptionRepository.findPrescriptionById(id);
        Prescription dispensablePrescription = prescription.get();*/

        String message = "Dispensed";

            if(dispensablePrescription.isPrescriptionValid() && dispensablePrescription.getPrescriptionType() == PrescriptionType.ONGOING){

                 dispensablePrescription.setExpiryDate(dispensablePrescription.getExpiryDate().plusDays(60));
                 Prescription updatedPrescription =  prescriptionRepository.save(dispensablePrescription);

                return Optional.of(new Dispense(message));
                        //Optional.of(PrescriptionDTOInterface.getTypeMap().map(updatedPrescription));

            }else if(dispensablePrescription.isPrescriptionValid() && dispensablePrescription.getPrescriptionType() == PrescriptionType.DISPOSABLE){

                dispensablePrescription.setExpiryDate(LocalDateTime.now());
                Prescription updatedPrescription =  prescriptionRepository.save(dispensablePrescription);

                return Optional.of(new Dispense(message));
                 //Optional.of(PrescriptionDTOInterface.getTypeMap().map(updatedPrescription));

            }else{
                return Optional.of(new Dispense("Prescription invalid!!!"));
                //Optional.empty();

            }
    }


}
