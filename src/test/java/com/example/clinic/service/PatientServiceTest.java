package com.example.clinic.service;

import com.example.clinic.model.Patient;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class PatientServiceTest {

    @Autowired
    private PatientService sut;

    @Test
    void retrievePatientByUsernameShouldReturnPatientLastNameMolendaForUsernameJuras() {

        //given
        String username = "juras";
        String expectedPatientLastName = "Molenda";

        //when
        Patient actualPatient = sut.retrievePatientByUsername(username).get();

        //then
        Assert.assertEquals(expectedPatientLastName, actualPatient.getLastName());

    }
}