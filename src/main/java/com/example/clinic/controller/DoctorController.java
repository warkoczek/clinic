package com.example.clinic.controller;

import com.example.clinic.domain.Doctor;
import com.example.clinic.model.DoctorDTO;
import com.example.clinic.domain.Specialization;
import com.example.clinic.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping(value = "/doctors", produces = "application/json")
    public List<Doctor> showAllDoctors(){
        return doctorService.retrieveAllDoctors();
    }

    @GetMapping(value = "/doctor", produces = "application/json")
    public ResponseEntity<Doctor> showDoctorByUsername(@RequestParam(required = false) String username){
        Optional<Doctor> doctor = doctorService.retrieveDoctorByUsername(username);
        if(!doctor.isPresent()) {
            System.out.println("Doctor with username " + username + " does not exist");
            return ResponseEntity.badRequest().build();
        }
            return ResponseEntity.ok(doctor.get());
    }

    @GetMapping(value = "/doctor/specialization", produces = "application/json")
    public Set<DoctorDTO> showDoctorsBySpecialization(@RequestParam(required = false)Specialization specialization){
        return doctorService.retrieveDoctorsBySpecialization(specialization);
    }
}
