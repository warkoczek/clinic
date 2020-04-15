package com.example.clinic.model.dto.appointment.reservedappointment;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
@NoArgsConstructor
public class ReservedAppointmentDTO {

    private String patientFullName;

    private String doctorFullName;

    private LocalDateTime appointmentDate;

    private String doorNumber;

    private String description;

    public ReservedAppointmentDTO(String patientFullName, String doctorFullName, LocalDateTime appointmentDate, String doorNumber, String description) {
        this.patientFullName = patientFullName;
        this.doctorFullName = doctorFullName;
        this.appointmentDate = appointmentDate;
        this.doorNumber = doorNumber;
        this.description = description;
    }

    public String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(String patientFirstName) {
        this.patientFullName = patientFirstName;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(String doctorLastName) {
        this.doctorFullName = doctorLastName;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
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
        return Objects.equals(patientFullName, that.patientFullName) &&
                Objects.equals(doctorFullName, that.doctorFullName) &&
                Objects.equals(appointmentDate, that.appointmentDate) &&
                Objects.equals(doorNumber, that.doorNumber) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientFullName, doctorFullName, appointmentDate, doorNumber, description);
    }
}
