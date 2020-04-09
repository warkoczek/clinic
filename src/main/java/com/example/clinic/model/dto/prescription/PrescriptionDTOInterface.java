package com.example.clinic.model.dto.prescription;

import com.example.clinic.domain.Prescription;
import com.example.clinic.model.dto.prescription.PrescriptionDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;

public interface PrescriptionDTOInterface {

     static TypeMap<Prescription, PrescriptionDTO> getTypeMap(){
         ModelMapper modelMapper = new ModelMapper();
         PropertyMap<Prescription, PrescriptionDTO> prescriptionMapper = getPrescriptionPropertyMap();
         return modelMapper.addMappings(prescriptionMapper);

    }

    private static PropertyMap<Prescription, PrescriptionDTO> getPrescriptionPropertyMap(){
        return new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setPrescriptionNumber(source.getId());
                map().setPrescriptionIssueDate(source.getIssueDate());
                map().setPrescriptionExpiryDate(source.getExpiryDate());
                map().setPatientFullName(source.getPatient().getFullName());
                map().setDoctorFullName(source.getDoctor().getFullName());
                map().setDescription(source.getDescription());
            }
        };
    }


}
