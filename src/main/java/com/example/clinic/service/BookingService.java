package com.example.clinic.service;

import com.example.clinic.domain.Appointment;
import com.example.clinic.domain.Patient;
import com.example.clinic.exception.AppointmentNotFoundException;
import com.example.clinic.model.dto.appointment.ReservedAppointmentDTO;
import com.example.clinic.model.dto.appointment.ReservedAppointmentDTOInterface;
import com.example.clinic.repository.AppointmentRepository;
import com.example.clinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookingService {

    private final AppointmentRepository appointmentRepository;

    private final PatientRepository patientRepository;

    public BookingService(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    //appointmentNumber is an appointment's id.
    public ReservedAppointmentDTO bookAppointment(String patientUsername, Long appointmentId){

        Optional<Patient> patient = patientRepository.findPatientByUsername(patientUsername);

        Optional<Appointment> bookedAppointment = appointmentRepository.findAppointmentById(appointmentId).stream()
                .findAny();
        bookedAppointment.ifPresentOrElse(appointment -> appointment.setPatient(patient.get()), () -> {
            throw new AppointmentNotFoundException("absent");
        });
        appointmentRepository.save(bookedAppointment.get());

        return ReservedAppointmentDTOInterface.getTypeMap().map(bookedAppointment.get());
    }

}
