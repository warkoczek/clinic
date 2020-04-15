package com.example.clinic.service;

import com.example.clinic.domain.Appointment;
import com.example.clinic.domain.Patient;
import com.example.clinic.exception.AppointmentNotFoundException;
import com.example.clinic.model.dto.appointment.ReservedAppointmentCreationDTO;
import com.example.clinic.model.dto.appointment.reservedappointment.ReservedAppointmentDTO;
import com.example.clinic.model.dto.appointment.reservedappointment.ReservedAppointmentDTOInterface;
import com.example.clinic.repository.AppointmentRepository;
import com.example.clinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookingService {

    private final AppointmentService appointmentService;

    private final PatientService patientService;

    public BookingService(AppointmentService appointmentService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
    }

    //appointmentNumber is an appointment's id.
    public Optional<ReservedAppointmentDTO> bookAppointment(ReservedAppointmentCreationDTO dto){

        Optional<Patient> patient = patientService.retrievePatientByUsername(dto.getPatientUsername());

        Optional<Appointment> bookedAppointment = appointmentService.retrieveAvailableAppointmentById(dto.getAppointmentId()).stream()
                .findAny();
        bookedAppointment.ifPresentOrElse(appointment -> appointment.setPatientAndDescription(patient.get(), dto.getDescription()), () -> {
                throw new AppointmentNotFoundException("Appointment with this id is UNAVAILABLE");
        });

        appointmentService.addBookedAppointment(bookedAppointment.get());

        return Optional.of(ReservedAppointmentDTOInterface.getTypeMap().map(bookedAppointment.get()));
    }


}
