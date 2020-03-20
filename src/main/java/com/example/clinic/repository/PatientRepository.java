package com.example.clinic.repository;

import com.example.clinic.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, String> {


   Optional<Patient> findPatientByUsername(String username);

}
