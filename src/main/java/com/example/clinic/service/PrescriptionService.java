package com.example.clinic.service;

import com.example.clinic.domain.Prescription;
import com.example.clinic.model.PrescriptionDTO;
import com.example.clinic.repository.PrescriptionRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
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

    public List<PrescriptionDTO> getPrescriptionsByPatient(String username){
        return  convertPrescriptionsToSetOfPrescriptionDTO(username);
    }

    private List<PrescriptionDTO> convertPrescriptionsToSetOfPrescriptionDTO(String username){

        return prescriptionRepository.findPrescriptionsByPatient_Username(username).stream()
                .map(prescription -> getPrescriptionTypeMap().map(prescription))
                .sorted(Comparator.comparing(PrescriptionDTO::getPrescriptionIssueDate))
                .collect(Collectors.toList());
    }
    private TypeMap<Prescription, PrescriptionDTO> getPrescriptionTypeMap(){
        ModelMapper modelMapper = new ModelMapper();
        PropertyMap<Prescription, PrescriptionDTO> prescriptionMapper = getPrescriptionPropertyMap();
        return modelMapper.addMappings(prescriptionMapper);
    }

    private PropertyMap<Prescription, PrescriptionDTO> getPrescriptionPropertyMap(){
        return new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setPrescriptionNumber(source.getId());
                map().setPrescriptionIssueDate(source.getPrescriptionIssueDate());
                map().setPatientFullName(source.getPatient().getFullName());
                map().setDoctorFullName(source.getDoctor().getFullName());
                map().setDescription(source.getDescription());
            }
        };
    }

    public Long addPrescription(Prescription prescription){
        prescriptionRepository.save(prescription);
        return prescription.getId();
    }







}
