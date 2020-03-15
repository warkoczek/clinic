package com.example.clinic.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(generator = "appointmentSeq")
    @SequenceGenerator(name = "appointmentSeq", sequenceName = "appointment_Seq", allocationSize = 1)
    private Long id;

    @ManyToOne(targetEntity = Patient.class)
    private Patient patient;

    @ManyToOne(targetEntity = Doctor.class)
    private Doctor doctor;

    private LocalDateTime appointmentDate;

    private String description;

    public Appointment() {
    }

    public Appointment(Doctor doctor, LocalDateTime appointmentDate){
        this.doctor=doctor;
        this.appointmentDate=appointmentDate;
    }

    public Appointment(Patient patient, Doctor doctor, LocalDateTime appointmentDate, String description){
        this.patient=patient;
        this.doctor=doctor;
        this.appointmentDate=appointmentDate;
        this.description=description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(doctor, that.doctor) &&
                Objects.equals(appointmentDate, that.appointmentDate) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctor, appointmentDate, description);
    }
}
