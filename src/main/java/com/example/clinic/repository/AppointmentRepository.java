package com.example.clinic.repository;


import com.example.clinic.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


    Optional<Appointment> findAppointmentById(Long appointmentId);

    List<Appointment> findAppointmentsByDoctor_UsernameAndPatientIsNull(String username);
}
