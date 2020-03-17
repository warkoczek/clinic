package com.example.clinic.service;


import com.example.clinic.model.Appointment;
import com.example.clinic.model.AppointmentDTO;
import com.example.clinic.model.AvailableAppointmentDTO;
import com.example.clinic.model.Doctor;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AppointmentServiceTest {

    @Autowired
    private AppointmentService sut;
    @Autowired
    private DoctorService doctorService;

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
    public void showAppointmentByIdShouldReturnIsEmptyTrueForAppointmentId100(){

        //given
        Long appointmentId = 100L;
        boolean expected = true;
        //when
        Optional<Appointment> actualAppointment = sut.showAppointmentById(appointmentId);

        //then
        assertThat(actualAppointment.isEmpty());

    }



   @Test
    public void convertToEntityListShouldReturn4AppointmentsForWorkingHours14To16() {

        //given
       String doctorUsername = doctorService.retrieveDoctorByUsername("mario").get().getUsername();

       /* Address address = new Address("Brzozowa", "1", "88700", "Piła", "Poland");
        Room room = new Room("1", "2");
        Doctor doctor = new Doctor(1L, "82121619936", "John", "Warki",
                Specialization.UROLOGIST, address, "+48500600540", "awar@wp.pl", room);

        */
        AppointmentDTO appointmentDto = new AppointmentDTO(doctorUsername, LocalDateTime.of(2020,04,04,14,00,00),
                LocalDateTime.of(2020,04,04,16,00,00), 30);

        int expectedListSize = 4;


        //when

        int actualListSize = sut.convertToEntity(appointmentDto).size();

        //then
        Assert.assertEquals(expectedListSize, actualListSize);
    }

    @Test
    void showAvailableAppointmentsByDoctorIdShouldReturnTwoAppointmentDatesForDoctorBogi() {

        //given
        String username = "bogi";
        int expectedListSize = 2;
        LocalDateTime expectedEarliestAppointmentDate = LocalDateTime.of(2020,07,22,13,30,00);

        //when
        int actualListSize = sut.showAvailableAppointmentsByDoctorId(username).size();
        LocalDateTime actualAppointmentDates = sut.showAvailableAppointmentsByDoctorId(username).get(0).getAppointmentDate();

        //then
        Assert.assertEquals(expectedListSize,actualListSize);
        Assert.assertEquals(expectedEarliestAppointmentDate,actualAppointmentDates);

    }
}