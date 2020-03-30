package com.example.clinic.service;

import com.example.clinic.domain.Doctor;
import com.example.clinic.domain.Patient;
import com.example.clinic.domain.Prescription;
import com.example.clinic.repository.DoctorRepository;
import com.example.clinic.repository.PatientRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class PrescriptionServiceTest {
    @Autowired
    private  PrescriptionService sut;
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
                3l,patient , doctor,"common flu, take vitamin C 3 times a day");
        Long expectedPrescriptionId = 4l;
        String expectedPrescriptionDescription = "common flu, take vitamin C 3 times a day";

        //when
        Long actualPrescriptionId = sut.addPrescription(prescription);
        String actualPrescriptionDescription = sut.getPrescriptionsByPatient(patient.getUsername()).get(0).getDescription();

        //then
        Assert.assertEquals(expectedPrescriptionId,actualPrescriptionId);
        Assert.assertEquals(expectedPrescriptionDescription,actualPrescriptionDescription);
    }
}