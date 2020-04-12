package com.example.clinic.service;

import com.example.clinic.domain.Appointment;
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
        String patientUsername = "juras";

        Long appointmentId = 7L;
        String expectedPatientFullName = "Jerzy Molenda";

        //when
        sut.bookAppointment(patientUsername,appointmentId);

        Optional<Appointment> appointmentOptional = appointmentService.retrieveAppointmentById(7L);
        String actualPatientFullName = appointmentOptional.get().getPatient().getFullName();

        //then
        Assert.assertEquals(expectedPatientFullName, actualPatientFullName);


    }
}
