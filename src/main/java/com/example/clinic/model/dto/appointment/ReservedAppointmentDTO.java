package com.example.clinic.model.dto.appointment;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
@NoArgsConstructor
public class ReservedAppointmentDTO {

    private String patientFirstName;

    private String doctorLastName;

    private LocalDateTime appointmentDate;

    private String roomDoorNumber;

    private String description;

    public ReservedAppointmentDTO(String patientFirstName, String doctorLastName, LocalDateTime appointmentDate,String roomDoorNumber,  String description) {
        this.patientFirstName = patientFirstName;
        this.doctorLastName = doctorLastName;
        this.appointmentDate = appointmentDate;
        this.roomDoorNumber=roomDoorNumber;
        this.description = description;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
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

    public String getRoomDoorNumber() {
        return roomDoorNumber;
    }

    public void setRoomDoorNumber(String roomDoorNumber) {
        this.roomDoorNumber = roomDoorNumber;
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
        return Objects.equals(patientFirstName, that.patientFirstName) &&
                Objects.equals(doctorLastName, that.doctorLastName) &&
                Objects.equals(appointmentDate, that.appointmentDate) &&
                Objects.equals(roomDoorNumber, that.roomDoorNumber) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientFirstName, doctorLastName, appointmentDate, roomDoorNumber, description);
    }
}
