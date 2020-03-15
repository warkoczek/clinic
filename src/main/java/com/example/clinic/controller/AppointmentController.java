package com.example.clinic.controller;

import com.example.clinic.model.Appointment;
import com.example.clinic.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping(value = "/appointments", produces = "application/json")
    public List<Appointment> showAllAppointments(){
        return appointmentService.retrieveAllAppointments();
    }

    @GetMapping(value = "/appointment", produces = "application/json")
    public ResponseEntity<Appointment> showAppointmentById(@RequestParam(required = false) Long id){
        Optional<Appointment> optionalAppointment = appointmentService.showAppointmentById(id);
        if(!optionalAppointment.isPresent()){
            System.out.println("Appointment with id " + id + "not found");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalAppointment.get());
    }
}
