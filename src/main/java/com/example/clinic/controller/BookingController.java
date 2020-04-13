package com.example.clinic.controller;

import com.example.clinic.model.dto.appointment.ReservedAppointmentCreationDTO;
import com.example.clinic.model.dto.appointment.reservedappointment.ReservedAppointmentDTO;
import com.example.clinic.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PutMapping(value = "/booking", produces = "application/json")
    public ResponseEntity<ReservedAppointmentDTO> bookAppointment(@RequestBody ReservedAppointmentCreationDTO dto){

        return bookingService.bookAppointment(dto)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
