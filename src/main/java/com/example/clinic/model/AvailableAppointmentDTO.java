package com.example.clinic.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class AvailableAppointmentDTO {


    private LocalDateTime appointmentDate;

    public AvailableAppointmentDTO() {
    }

    public AvailableAppointmentDTO(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }


    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvailableAppointmentDTO that = (AvailableAppointmentDTO) o;
        return Objects.equals(appointmentDate, that.appointmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentDate);
    }
}
