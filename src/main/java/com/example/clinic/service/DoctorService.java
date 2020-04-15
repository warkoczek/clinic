package com.example.clinic.service;

import com.example.clinic.domain.Doctor;
import com.example.clinic.model.dto.doctor.DoctorDTO;
import com.example.clinic.domain.Specialization;
import com.example.clinic.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> retrieveAllDoctors(){
        return doctorRepository.findAll();
    }

    public Optional<Doctor> retrieveDoctorByUsername(String username){

        return doctorRepository.findDoctorByUsername(username);
    }


    public Set<DoctorDTO> retrieveDoctorsBySpecialization(Specialization specialization) {

         return doctorRepository.findDoctorBySpecialization(specialization).stream()
         .filter(doctor -> doctor.getSpecialization().equals(specialization))
         .map(this::convertDoctorToDoctorDTO)
         .collect(Collectors.toSet());
    }

    private DoctorDTO convertDoctorToDoctorDTO(Doctor doctor){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(doctor, DoctorDTO.class);

    }
}
