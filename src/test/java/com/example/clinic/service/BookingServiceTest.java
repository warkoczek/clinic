package com.example.clinic.service;

import com.example.clinic.domain.Appointment;
import com.example.clinic.model.dto.appointment.ReservedAppointmentCreationDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BookingServiceTest {

    @Autowired
    private BookingService sut;

    @Autowired
    private AppointmentService appointmentService;


    @Test
    void bookAppointmentShouldReturnPatientFullNameJerzyMolendaForReservedAppointmentWithId7(){

        //given
        Long appointmentId = 7L;
        String patientUsername = "juras";
        String description = "flu";
        ReservedAppointmentCreationDTO dto = new ReservedAppointmentCreationDTO(appointmentId, patientUsername, description);

        String expectedPatientFullName = "Jerzy Molenda";

        //when
        sut.bookAppointment(dto);

        Optional<Appointment> appointmentOptional = appointmentService.retrieveAppointmentById(7L);
        String actualPatientFullName = appointmentOptional.get().getPatient().getFullName();

        //then
        Assert.assertEquals(expectedPatientFullName, actualPatientFullName);


    }
}
