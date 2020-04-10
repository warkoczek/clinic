package com.example.clinic.model.dto.appointment;

import com.example.clinic.domain.Appointment;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;

public interface ReservedAppointmentDTOInterface {

    static TypeMap<Appointment, ReservedAppointmentDTO> getTypeMap(){
        ModelMapper modelMapper = new ModelMapper();
        PropertyMap<Appointment, ReservedAppointmentDTO> prescriptionMapper = getPrescriptionPropertyMap();
        return modelMapper.addMappings(prescriptionMapper);

    }

    private static PropertyMap<Appointment, ReservedAppointmentDTO> getPrescriptionPropertyMap(){
        return new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setAppointmentDate(source.getAppointmentDate());
            }
        };
    }
}
