package com.example.clinic.service;

import com.example.clinic.domain.Doctor;
import com.example.clinic.model.DoctorDTO;
import com.example.clinic.domain.Specialization;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class DoctorServiceTest {

    @Autowired
    private DoctorService sut;


    @Test
    void retrieveDoctorByUsernameShouldReturnDoctorLastNameWituckiForUsernameOlek() {

        //given
        String username = "olek";
        String expectedLastName = "Witucki";

        //when
        Doctor doctor = sut.retrieveDoctorByUsername(username).get();

        //then
        Assert.assertEquals(expectedLastName,doctor.getLastName());

    }

    @Test
    void retrieveDoctorBySpecializationShouldReturnSetOfDoctorsWithSize2ForUrologist(){

        //given
        Specialization specialization = Specialization.UROLOGIST;
        int expectedSize = 2;

        //when
        Set<DoctorDTO> actualDoctors = sut.retrieveDoctorsBySpecialization(specialization);

        //then
        Assert.assertEquals(expectedSize, actualDoctors.size());
    }

}