package com.example.clinic.repository;

import com.example.clinic.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findPrescriptionsByPatient_Username(String username);
    Optional<Prescription> findPrescriptionById(Long id);



}
