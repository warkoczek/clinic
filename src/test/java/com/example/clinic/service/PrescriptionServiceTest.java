package com.example.clinic.service;

import com.example.clinic.domain.*;
import com.example.clinic.model.dto.prescription.PrescriptionDTO;
import com.example.clinic.repository.DoctorRepository;
import com.example.clinic.repository.PatientRepository;
import com.example.clinic.repository.PrescriptionRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class PrescriptionServiceTest {

    @Autowired
    private  PrescriptionService sut;
    @Autowired
    private PrescriptionRepository  prescriptionRepository;
    @Autowired
    private  PatientRepository patientRepository;
    @Autowired
    private  DoctorRepository doctorRepository;



    @Test
    void addPrescriptionShouldReturnPrescriptionId4forNewPrescription() {
        //given
        Patient patient = patientRepository.findPatientByUsername("juras").get();
        Doctor doctor = doctorRepository.findDoctorByUsername("mario").get();
        Prescription prescription = new Prescription(LocalDateTime.of(2020,03,29,9,00,00),
                LocalDateTime.of(2020,04,29,00,00,00), PrescriptionType.ONGOING
                , patient , doctor,"common flu, take vitamin C 3 times a day");
        Long expectedPrescriptionId = 5l;
        String expectedPrescriptionDescription = "common flu, take vitamin C 3 times a day";

        //when
        Long actualPrescriptionId = sut.addPrescription(prescription);
        String actualPrescriptionDescription = sut.getPrescriptionsByPatient(patient.getUsername()).get(1).getDescription();

        //then
        Assert.assertEquals(expectedPrescriptionId,actualPrescriptionId);
        Assert.assertEquals(expectedPrescriptionDescription,actualPrescriptionDescription);
    }

    @Test
    public void dispenseMedicineShouldReturnNewExpiryDateForOngoingPrescriptionWithId1(){
        //given
        Long prescriptionId = 1l;
        LocalDateTime expectedExpiryDate = LocalDateTime.of(2020, 10, 02, 00, 00 ,00);

        //when
        sut.dispenseMedicine(prescriptionId);
        LocalDateTime actualExpiryDate = sut.getPrescriptionById(prescriptionId).get().getPrescriptionExpiryDate();

        //then
        Assert.assertEquals(expectedExpiryDate, actualExpiryDate);
    }

   @Test
    public void dispenseMedicineShouldReturnPrescriptionInValidForDisposablePrescriptionWithId3(){
        //given
        Long prescriptionId = 3l;
        Dispense dispense = new Dispense("Prescription invalid!!!");
        Optional<Dispense> expectedMessage = Optional.of(dispense);

        //when
        Optional<Dispense> actualMessage = sut.dispenseMedicine(prescriptionId);

        //then
        Assert.assertEquals(expectedMessage.get().getMessage(), actualMessage.get().getMessage());


    }

    @Test
    public void dispenseMedicineShouldReturnMessageDispensedForOngoingPrescriptionWithId1(){
        //given
        Long prescriptionId = 1l;
        Dispense dispense = new Dispense("Dispensed");
        Optional<Dispense> expectedMessage = Optional.of(dispense);

        //when
        Optional<Dispense> actualMessage = sut.dispenseMedicine(prescriptionId);

        //then
        Assert.assertEquals(expectedMessage.get().getMessage(), actualMessage.get().getMessage());


    }



}
