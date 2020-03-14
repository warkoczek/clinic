package com.example.clinic.service;

import com.example.clinic.model.Patient;



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

    @Test
    public void removePatientByUsernameShouldReturnIsEmptyTrueAfterDeletingPatient(){

        //given
        Patient patient = new Patient("aro", "kazee", "Arkadiusz", "Kazmierczak", null, null, null);

        int expectedSize = 3;
        //when
        sut.addPatient(patient);
        sut.removePatientByUsername(patient.getUsername());
        int actualSize = sut.retrieveAllPatients().size();
        Optional<Patient> actualPatient = sut.retrievePatientByUsername(patient.getUsername());

        //then
        Assert.assertEquals(expectedSize,actualSize);
        assertThat(actualPatient.isEmpty());
    }
    //Postman update shows null for pii
    @Test
    public void updatePatientShouldReturnUpdatedLastNameMalickiForPatientWithUsernameGrek(){

        //given
        Patient newPatient = new Patient("grek", "yty", "Grzegorz", "Malicki", null, null, null);
        String expectedLastName = "Malicki";

        //when
        Patient updatedPatient = sut.updatePatient(newPatient);

        //then
        Assert.assertEquals(expectedLastName, updatedPatient.getLastName());
    }

    @Test
    public void getAddressByPatientIdShouldReturnCityGnieznoForPatientUsernameZyga(){

        //given
        String username = "zyga";
        String expectedCity = "Gniezno";

        //when
        String actualCity = sut.retrievePatientByUsername(username).get().getAddress().getCity();

        //then
        Assert.assertEquals(expectedCity, actualCity);

    }


}