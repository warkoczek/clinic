package com.example.clinic.repository;

import com.example.clinic.domain.Doctor;
import com.example.clinic.domain.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface DoctorRepository extends JpaRepository<Doctor, String> {

    Optional<Doctor> findDoctorByUsername(String username);

    Set<Doctor> findDoctorBySpecialization(Specialization specialization);
}
