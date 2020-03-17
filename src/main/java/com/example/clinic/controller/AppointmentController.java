package com.example.clinic.controller;

import com.example.clinic.model.Appointment;
import com.example.clinic.model.AppointmentDTO;
import com.example.clinic.model.AvailableAppointmentDTO;
import com.example.clinic.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @GetMapping(value = "/appointments/available/doctor", produces = "application/json")
    public List<AvailableAppointmentDTO> showAvailableAppointmentsByDoctorId(@RequestParam String username){
        return appointmentService.showAvailableAppointmentsByDoctorId(username);
    }

    @PostMapping(value = "/appointments/add", consumes = "application/json")
    public List<Appointment> addAvailableAppointments(@RequestBody AppointmentDTO appointmentDto){
        return appointmentService.addAvailableAppointments(appointmentDto);
    }


}
