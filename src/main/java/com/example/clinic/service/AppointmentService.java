package com.example.clinic.service;

import com.example.clinic.model.Appointment;
import com.example.clinic.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> retrieveAllAppointments(){
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> showAppointmentById(Long appointmentId){

        return appointmentRepository.findAppointmentById(appointmentId);
    }
}
