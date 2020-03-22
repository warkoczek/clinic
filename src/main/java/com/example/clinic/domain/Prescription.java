package com.example.clinic.domain;

import com.example.clinic.domain.Doctor;
import com.example.clinic.domain.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Prescription {

    @Id
    @GeneratedValue(generator = "prescriptionSeq")
    @SequenceGenerator(name = "prescriptionSeq", sequenceName = "prescription_Seq")
    private Long id;

    @ManyToOne(targetEntity = Patient.class)
    private Patient patient;

    @ManyToOne(targetEntity = Doctor.class)
    private Doctor doctor;

    private String description;


}
