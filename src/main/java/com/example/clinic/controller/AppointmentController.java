package com.example.clinic.controller;

import com.example.clinic.domain.Appointment;
import com.example.clinic.model.AppointmentDTO;
import com.example.clinic.model.AvailableAppointmentDTO;
import com.example.clinic.model.ReservedAppointmentDTO;
import com.example.clinic.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
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
        Optional<Appointment> optionalAppointment = appointmentService.retrieveAppointmentById(id);
        if(!optionalAppointment.isPresent()){
            System.out.println("Appointment with id " + id + "not found");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalAppointment.get());
    }

    @GetMapping(value = "/appointments/available/doctor", produces = "application/json")
    public List<AvailableAppointmentDTO> showAvailableAppointmentsByDoctorId(@RequestParam String username){
        return appointmentService.retrieveAvailableAppointmentsByDoctorId(username);
    }

    @GetMapping(value = "/reserved/doctor", produces = "application/json")
    public List<ReservedAppointmentDTO> showReservedAppointmentsByDoctorId(@RequestParam String username){
        return appointmentService.retrieveReservedAppointmentsByDoctorId(username);
    }

    @PostMapping(value = "/appointments/add", consumes = "application/json")
    public List<Appointment> addAvailableAppointments(@RequestBody AppointmentDTO appointmentDto){
        return appointmentService.addAvailableAppointments(appointmentDto);
    }


}
