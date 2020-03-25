package com.example.clinic.service;


import com.example.clinic.domain.Appointment;
import com.example.clinic.model.AppointmentDTO;
import com.example.clinic.model.ReservedAppointmentDTO;
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
         LocalTime actualAppointmentTime = sut.retrieveAppointmentById(appointmentId).get().getAppointmentDate().toLocalTime();

         //then
        Assert.assertEquals(expectedAppointmentTime,actualAppointmentTime);
    }

    @Test
    public void showAppointmentByIdShouldReturnIsEmptyTrueForAppointmentId100(){

        //given
        Long appointmentId = 100L;
        boolean expected = true;
        //when
        Optional<Appointment> actualAppointment = sut.retrieveAppointmentById(appointmentId);

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
                LocalDateTime.of(2020,04,04,16,00,00), true, 30);

        int expectedListSize = 4;


        //when

        int actualListSize = sut.convertToEntity(appointmentDto).size();

        //then
        Assert.assertEquals(expectedListSize, actualListSize);
    }
    /*@Test
    void getListOfAvailableCyclicAppointmentsShouldReturnListSize8ForGivenAppointmentDTO(){
        //given
        String doctorUsername = doctorService.retrieveDoctorByUsername("mario").get().getUsername();
        AppointmentDTO appointmentDTO = new AppointmentDTO(doctorUsername, LocalDateTime.of(2020,04,04,14,00,00),
                LocalDateTime.of(2020,04,04,15,00,00), true, 30);
        int expectedListSize = 8;
        //when
        List<Appointment> listOfAvailableCyclicAppointments = sut.addAvailableAppointments(appointmentDTO);
        //then
        Assert.assertEquals(expectedListSize,listOfAvailableCyclicAppointments.size());
    }*/

    @Test
    void showAvailableAppointmentsByDoctorIdShouldReturnTwoAppointmentDatesForDoctorBogi() {

        //given
        String username = "bogi";
        int expectedListSize = 2;
        LocalDateTime expectedEarliestAppointmentDate = LocalDateTime.of(2020,07,22,13,30,00);

        //when
        int actualListSize = sut.retrieveAvailableAppointmentsByDoctorId(username).size();
        LocalDateTime actualAppointmentDates = sut.retrieveAvailableAppointmentsByDoctorId(username).get(0).getAppointmentDate();

        //then
        Assert.assertEquals(expectedListSize,actualListSize);
        Assert.assertEquals(expectedEarliestAppointmentDate,actualAppointmentDates);

    }

    @Test
    void retrieveReservedAppointmentsByDoctorIdShouldReturnListSize1AndPatientLastNameWiburskiForDoctorUsernameMario(){
        //given
            String username = "mario";
            int expectedListSize = 1;
            String expectedPatientLastName = "Zygmunt";
        //when
        List<ReservedAppointmentDTO> actualReservedAppointmentDTOList = sut.retrieveReservedAppointmentsByDoctorId(username);

        //then
        Assert.assertEquals(expectedListSize, actualReservedAppointmentDTOList.size());
        Assert.assertEquals(expectedPatientLastName,actualReservedAppointmentDTOList.get(0).getPatientFirstName());
    }

    @Test
    void retrieveReservedAppointmentsByDoctorIdShouldReturnDoorNumber2ForDoctorUsernameMario(){
        //given
        String username = "mario";
        String expectedDoorNumber = "4";

        //when
        String actualDoorNumber = sut.retrieveReservedAppointmentsByDoctorId(username).get(0).getRoomDoorNumber();
        //then
        Assert.assertEquals(expectedDoorNumber, actualDoorNumber);
    }

    @Test
    void retrieveReservedAppointmentsByRoomShouldReturnListSize1ForRoomDoorNumber4() {

        //given
        String doorNumber = "4";
        int expectedListSize = 1;
        //when
        List<ReservedAppointmentDTO> actualReservedAppointmentDTOList = sut.retrieveReservedAppointmentsByRoom(doorNumber);
        //then
        Assert.assertEquals(expectedListSize, actualReservedAppointmentDTOList.size());

    }

    @Test
    void postponeReservedAppointmentsByDoctorIdShouldReturnDate24AprilForReservedAppointmentWithDoctorMario(){
        //given
        String username = "mario";
        LocalDateTime expectedPostponedDate = LocalDateTime.of(2020, 04, 04, 15, 30 ,00);
        //when
        List<Appointment> actualPostponedReservedAppointmentsByDoctorId = sut.postponeReservedAppointmentsByDoctorId(username);
        //then
        Assert.assertEquals(expectedPostponedDate, actualPostponedReservedAppointmentsByDoctorId.get(0).getAppointmentDate());

    }

}