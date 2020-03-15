package com.example.clinic.repository;


import com.example.clinic.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


    Optional<Appointment> findAppointmentById(Long appointmentId);
}
