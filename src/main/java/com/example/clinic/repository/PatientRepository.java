package com.example.clinic.repository;

import com.example.clinic.domain.Patient;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, String> {


   Optional<Patient> findPatientByUsername(String username);


}
