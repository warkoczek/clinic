package com.example.clinic.repository;

import com.example.clinic.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findPrescriptionsByPatient_Username(String username);



}
