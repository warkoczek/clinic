package com.example.clinic.model.dto.appointment.availableappointment;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
@NoArgsConstructor
public class AvailableAppointmentDTO {

    private Long appointmentNumber;

    private LocalDateTime appointmentDate;

    private String doctorFullName;

    private String doorNumber;


    public AvailableAppointmentDTO(Long appointmentNumber, LocalDateTime appointmentDate, String doctorFullName, String doorNumber) {
        this.appointmentNumber=appointmentNumber;
        this.appointmentDate = appointmentDate;
        this.doctorFullName = doctorFullName;
        this.doorNumber = doorNumber;
    }

    public Long getAppointmentNumber() {
        return appointmentNumber;
    }

    public void setAppointmentNumber(Long appointmentNumber) {
        this.appointmentNumber = appointmentNumber;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvailableAppointmentDTO that = (AvailableAppointmentDTO) o;
        return Objects.equals(appointmentNumber, that.appointmentNumber) &&
                Objects.equals(appointmentDate, that.appointmentDate) &&
                Objects.equals(doctorFullName, that.doctorFullName) &&
                Objects.equals(doorNumber, that.doorNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentNumber, appointmentDate, doctorFullName, doorNumber);
    }
}
