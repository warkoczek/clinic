package com.example.clinic.controller;

import com.example.clinic.model.dto.appointment.ReservedAppointmentDTO;
import com.example.clinic.service.BookingService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PutMapping(value = "/booking", produces = "application/json")
    public ReservedAppointmentDTO bookAppointment(@RequestParam String patientUsername, Long appointmentId){
        return bookingService.bookAppointment(patientUsername, appointmentId);
    }
}
