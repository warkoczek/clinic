package com.example.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
@NoArgsConstructor
public class ReservedAppointmentDTO {

    private String patientLastName;

    private String doctorLastName;

    private LocalDateTime appointmentDate;

    private String description;

    public ReservedAppointmentDTO(String patientLastName, String doctorLastName, LocalDateTime appointmentDate, String description) {
        this.patientLastName = patientLastName;
        this.doctorLastName = doctorLastName;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
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
        ReservedAppointmentDTO that = (ReservedAppointmentDTO) o;
        return Objects.equals(patientLastName, that.patientLastName) &&
                Objects.equals(doctorLastName, that.doctorLastName) &&
                Objects.equals(appointmentDate, that.appointmentDate) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientLastName, doctorLastName, appointmentDate, description);
    }
}
