package com.example.clinic.service;

import com.example.clinic.model.Address;
import com.example.clinic.model.PII;
import com.example.clinic.model.Patient;


import com.example.clinic.model.Role;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


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

    @Test
    public void addPatientShouldReturnListSize4AndNotNullTrueAfterAddingNewPatient(){

        //given
        Patient patient = new Patient("rycho", "bioly", "Rich", "Warkozewski", null, null, null);

        int expectedSize=4;
        String expectedUsername = "rycho";

        //when
        sut.addPatient(patient);
        int actualSize = sut.retrieveAllPatients().size();
        Optional<Patient> actualPatient = sut.retrievePatientByUsername(expectedUsername);

        //then
        Assert.assertEquals(expectedSize,actualSize);
        assertThat(actualPatient.isPresent());
    }
}