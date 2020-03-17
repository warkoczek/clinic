package com.example.clinic.service;

import com.example.clinic.model.Appointment;
import com.example.clinic.model.AppointmentDTO;
import com.example.clinic.model.AvailableAppointmentDTO;
import com.example.clinic.model.Doctor;
import com.example.clinic.model.dto.DtoToEntity;
import com.example.clinic.repository.AppointmentRepository;
import com.example.clinic.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppointmentService{

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository=doctorRepository;
    }

    public List<Appointment> retrieveAllAppointments(){
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> showAppointmentById(Long appointmentId){

        return appointmentRepository.findAppointmentById(appointmentId);
    }

    public List<AvailableAppointmentDTO> showAvailableAppointmentsByDoctorId(String username){

         List<Appointment> appointments = appointmentRepository.findAppointmentsByDoctor_UsernameAndPatientIsNull(username);
         List<AvailableAppointmentDTO> availableAppointmentDTO = convertToDTOSet(appointments);
        return  availableAppointmentDTO.stream()
                 .sorted(Comparator.comparing(AvailableAppointmentDTO::getAppointmentDate))
                 .collect(Collectors.toList());
    }

    private List<AvailableAppointmentDTO> convertToDTOSet(List<Appointment> appointments){
        ModelMapper modelMapper = new ModelMapper();
        return appointments.stream()
                .map(appointment -> modelMapper.map(appointment,AvailableAppointmentDTO.class))
                .collect(Collectors.toList());

    }

    public List<Appointment> addAvailableAppointments(AppointmentDTO dto){

        return appointmentRepository.saveAll(convertToEntity(dto));
    }

    public List<Appointment> convertToEntity(AppointmentDTO dto) {

        List<Appointment> appointments= new ArrayList<>();

        LocalTime startTime = dto.getFrom().toLocalTime();

        LocalTime endTime = dto.getUnTill().toLocalTime();

        int duration = dto.getDuration();

        LocalTime appointmentTime = startTime;

        while (appointmentTime.isBefore(endTime)) {

            Appointment appointment = new Appointment();
            appointment.setDoctor(getDoctorByUsername(dto));
            appointment.setAppointmentDate(dto.getFrom());

            appointments.add(appointment);

            appointmentTime = appointmentTime.plusMinutes(duration);
        }

        return appointments;
    }

    private Doctor getDoctorByUsername(AppointmentDTO dto){
        String username = dto.getDoctorUsername();
        return doctorRepository.findDoctorByUsername(username).get();

    }
}
