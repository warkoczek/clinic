package com.example.clinic.service;


import com.example.clinic.model.Appointment;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AppointmentServiceTest {

    @Autowired
    private AppointmentService sut;

    @Test
    public void showAppointmentByIdShouldReturnAppointmentTime3ForId5(){

        //given
        Long appointmentId = 5l;
        LocalTime expectedAppointmentTime = LocalTime.of(15,00,00);

        //when
         LocalTime actualAppointmentTime = sut.showAppointmentById(appointmentId).get().getAppointmentDate().toLocalTime();

         //then
        Assert.assertEquals(expectedAppointmentTime,actualAppointmentTime);
    }

    @Test
    public void showAppointmentByIdShouldReturnIsEmptyTrueForAppointmentId10(){

        //given
        Long appointmentId = 10L;
        boolean expected = true;
        //when
        Optional<Appointment> actualAppointment = sut.showAppointmentById(appointmentId);

        //then
        assertThat(actualAppointment.isEmpty());

    }
}