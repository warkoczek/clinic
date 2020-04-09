package com.example.clinic.service;

import com.example.clinic.domain.Appointment;
import com.example.clinic.domain.Doctor;
import com.example.clinic.model.dto.appointment.AppointmentDTO;
import com.example.clinic.model.dto.appointment.AvailableAppointmentDTO;
import com.example.clinic.model.dto.appointment.ReservedAppointmentDTO;
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

    public Optional<Appointment> retrieveAppointmentById(Long appointmentId){

        return appointmentRepository.findAppointmentById(appointmentId);
    }


    public List<AvailableAppointmentDTO> retrieveAvailableAppointmentsByDoctorId(String username){

         List<Appointment> appointments = appointmentRepository.findAppointmentsByDoctor_UsernameAndPatientIsNull(username);
         List<AvailableAppointmentDTO> availableAppointmentDTOList = convertToListOfDTOs(appointments);
        return  availableAppointmentDTOList.stream()
                 .sorted(Comparator.comparing(AvailableAppointmentDTO::getAppointmentDate))
                 .collect(Collectors.toList());
    }

    private List<AvailableAppointmentDTO> convertToListOfDTOs(List<Appointment> appointments){
        ModelMapper modelMapper = new ModelMapper();
        return appointments.stream()
                .map(appointment -> modelMapper.map(appointment,AvailableAppointmentDTO.class))
                .collect(Collectors.toList());

    }

    public List<ReservedAppointmentDTO> retrieveReservedAppointmentsByDoctorId(String username){

        List<Appointment> appointments = appointmentRepository.findAppointmentsByDoctor_UsernameAndPatientIsNotNull(username);
        List<ReservedAppointmentDTO> reservedAppointmentDTOList = convertToListOfReservedAppointmentsDTO(appointments);
        return reservedAppointmentDTOList.stream()
                .sorted(Comparator.comparing(ReservedAppointmentDTO::getAppointmentDate))
                .collect(Collectors.toList());

    }

    public List<ReservedAppointmentDTO> retrieveReservedAppointmentsByRoom(String doorNumber){

        List<Appointment> appointments = appointmentRepository.findAppointmentsByRoom_DoorNumber(doorNumber);
        return convertToListOfReservedAppointmentsDTO(appointments)
                .stream().sorted(Comparator.comparing(ReservedAppointmentDTO::getAppointmentDate))
                .collect((Collectors.toList()));

    }

    private List<ReservedAppointmentDTO> convertToListOfReservedAppointmentsDTO(List<Appointment> appointments) {
        ModelMapper modelMapper = new ModelMapper();
        return appointments.stream()
                .map(appointment -> modelMapper.map(appointment, ReservedAppointmentDTO.class))
                .collect(Collectors.toList());
    }



    public List<Appointment> addAvailableAppointments(AppointmentDTO dto){

        return appointmentRepository.saveAll(convertToEntity(dto));
    }

   /* public List<Appointment> getListOfAvailableCyclicAppointments(AppointmentDTO dto){

        List<Appointment> allAppointments = new ArrayList<>();
            LocalDateTime nextDay = dto.getFrom();
        if(dto.isCyclic()){
            while(nextDay.isBefore(nextDay.plusDays(22))) {
                 allAppointments.addAll(convertToEntity(dto));
                 nextDay = nextDay.plusDays(7);
            }
        }else {
            allAppointments = convertToEntity(dto);
        }
        return allAppointments;
    }*/

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


    public List<Appointment> postponeReservedAppointmentsByDoctorId(String username){

        List<Appointment> postponedAppointments = new ArrayList<>();

         List<Appointment> appointmentsToPostpone = appointmentRepository.findAppointmentsByDoctor_UsernameAndPatientIsNotNull(username);

             appointmentsToPostpone.stream()
                .map(appointment -> {
                     appointment.setAppointmentDate(appointment.getAppointmentDate().plusWeeks(2));
                    return postponedAppointments.add(appointment);
                })
                .collect(Collectors.toList());

        appointmentRepository.deleteAll(appointmentsToPostpone);
       return appointmentRepository.saveAll(postponedAppointments);
    }
}
