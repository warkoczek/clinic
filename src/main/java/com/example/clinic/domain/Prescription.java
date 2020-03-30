package com.example.clinic.domain;

import com.example.clinic.domain.Doctor;
import com.example.clinic.domain.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Prescription {

    @Id
    @GeneratedValue(generator = "prescriptionSeq")
    @SequenceGenerator(name = "prescriptionSeq", sequenceName = "prescription_Seq", allocationSize = 1)
    private Long id;

    private LocalDateTime prescriptionIssueDate;

    private Long prescriptionValidity;

    private LocalDateTime medicineDispenseDate;


    @ManyToOne(targetEntity = Patient.class)
    private Patient patient;

    @ManyToOne(targetEntity = Doctor.class)
    private Doctor doctor;

    private String description;

    public Prescription(LocalDateTime prescriptionIssueDate, Long prescriptionValidity, Patient patient, Doctor doctor, String description) {
        this.prescriptionIssueDate=prescriptionIssueDate;
        this.prescriptionValidity=prescriptionValidity;
        this.patient=patient;
        this.doctor=doctor;
        this.description=description;
    }

    public boolean isPrescriptionValid(){
        LocalDateTime expiryDate = getPrescriptionIssueDate().plusMonths(prescriptionValidity);

        return expiryDate.isAfter(LocalDateTime.now());

    }


}
