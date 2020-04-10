package com.example.clinic.model.dto.appointment;

import com.example.clinic.domain.Appointment;
import com.example.clinic.domain.Prescription;
import com.example.clinic.model.dto.prescription.PrescriptionDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;

public interface AvailableAppointmentDTOInterface {

     static TypeMap<Appointment, AvailableAppointmentDTO> getTypeMap(){
        ModelMapper modelMapper = new ModelMapper();
        PropertyMap<Appointment, AvailableAppointmentDTO> prescriptionMapper = getPrescriptionPropertyMap();
        return modelMapper.addMappings(prescriptionMapper);

    }

    private static PropertyMap<Appointment, AvailableAppointmentDTO> getPrescriptionPropertyMap(){
        return new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setAppointmentDate(source.getAppointmentDate());
            }
        };
    }

}
