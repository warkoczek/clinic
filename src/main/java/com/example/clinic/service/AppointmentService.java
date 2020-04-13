package com.example.clinic.service;

import com.example.clinic.domain.Appointment;
import com.example.clinic.domain.Doctor;
import com.example.clinic.model.dto.appointment.*;
import com.example.clinic.model.dto.appointment.availableappointment.AvailableAppointmentDTO;
import com.example.clinic.model.dto.appointment.availableappointment.AvailableAppointmentDTOInterface;
import com.example.clinic.model.dto.appointment.reservedappointment.ReservedAppointmentDTO;
import com.example.clinic.model.dto.appointment.reservedappointment.ReservedAppointmentDTOInterface;
import com.example.clinic.repository.AppointmentRepository;
import com.example.clinic.repository.DoctorRepository;
import com.example.clinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppointmentService{

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository=doctorRepository;
        this.patientRepository=patientRepository;
    }

    public List<Appointment> retrieveAllAppointments(){
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> retrieveAppointmentById(Long appointmentId){

        return appointmentRepository.findAppointmentById(appointmentId);
    }

    public Optional<Appointment> retrieveAvailableAppointmentById(Long appointmentId){
        return appointmentRepository.findAppointmentByIdAndPatientIsNull(appointmentId);
    }

    public List<AvailableAppointmentDTO> retrieveAvailableAppointmentsByDoctorId(String username){

         List<Appointment> appointments = appointmentRepository.findAppointmentsByDoctor_UsernameAndPatientIsNull(username);
         return appointments.stream()
                 .map(appointment -> AvailableAppointmentDTOInterface.getTypeMap().map(appointment))
                 .sorted(Comparator.comparing(AvailableAppointmentDTO::getAppointmentDate))
                 .collect(Collectors.toList());

    }

    public List<ReservedAppointmentDTO> retrieveReservedAppointmentsByDoctorId(String username){

        List<Appointment> appointments = appointmentRepository.findAppointmentsByDoctor_UsernameAndPatientIsNotNull(username);

        return appointments.stream()
                .map(appointment -> ReservedAppointmentDTOInterface.getTypeMap().map(appointment))
                .sorted(Comparator.comparing(ReservedAppointmentDTO::getAppointmentDate))
                .collect(Collectors.toList());

    }

    public List<ReservedAppointmentDTO> retrieveReservedAppointmentsByRoom(String doorNumber){

        List<Appointment> appointments = appointmentRepository.findAppointmentsByRoom_DoorNumberAndPatientIsNotNull(doorNumber);
        return appointments
                .stream()
                .map(appointment -> ReservedAppointmentDTOInterface.getTypeMap().map(appointment))
                .sorted(Comparator.comparing(ReservedAppointmentDTO::getAppointmentDate))
                .collect((Collectors.toList()));
    }

    public Appointment addBookedAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }
    //allows Doctor adding available appointments
    public List<Appointment> addAvailableAppointments(AppointmentCreationDTO dto){

        return appointmentRepository.saveAll(convertToAppointmentList(dto));
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


    protected List<Appointment> convertToAppointmentList(AppointmentCreationDTO dto) {

        List<Appointment> appointments= new ArrayList<>();

        LocalTime startTime = dto.getFrom().toLocalTime();

        LocalTime endTime = dto.getTo().toLocalTime();

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

    private Doctor getDoctorByUsername(AppointmentCreationDTO dto){
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
