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
import java.util.Optional;
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

    private LocalDateTime issueDate;

    private LocalDateTime expiryDate;

    @Enumerated(value = EnumType.STRING)
    private PrescriptionType prescriptionType;


    @ManyToOne(targetEntity = Patient.class)
    private Patient patient;

    @ManyToOne(targetEntity = Doctor.class)
    private Doctor doctor;

    private String description;

    public Prescription(LocalDateTime issueDate, LocalDateTime expiryDate, PrescriptionType prescriptionType
            ,Patient patient, Doctor doctor, String description){
        this.issueDate=issueDate;
        this.expiryDate=expiryDate;
        this.prescriptionType=prescriptionType;
        this.patient=patient;
        this.doctor=doctor;
        this.description=description;
    }


    //if its less than 6months since IssueDate and medicineDispenseDate is null or is more than 6 months since lastDispenseDate for ongoing Prescription
    public boolean isPrescriptionValid(){

            if(getPrescriptionExpiryDate().isPresent()){
                LocalDateTime expiryDate = getPrescriptionExpiryDate().get();
                return expiryDate.isAfter(LocalDateTime.now());
            }
            return false;

    }

    public Optional<LocalDateTime> getPrescriptionExpiryDate(){
        return Optional.ofNullable(expiryDate);
    }
}
