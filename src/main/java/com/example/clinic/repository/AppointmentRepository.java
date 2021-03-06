package com.example.clinic.repository;


import com.example.clinic.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


    Optional<Appointment> findAppointmentById(Long appointmentId);

    Optional<Appointment> findAppointmentByIdAndPatientIsNull(Long appointmentId);

    List<Appointment> findAppointmentsByDoctor_UsernameAndPatientIsNull(String username);

    List<Appointment> findAppointmentsByDoctor_UsernameAndPatientIsNotNull(String username);

    List<Appointment> findAppointmentsByRoom_DoorNumberAndPatientIsNotNull(String doorNumber);


}
