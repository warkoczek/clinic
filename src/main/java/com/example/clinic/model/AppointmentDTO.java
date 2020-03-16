package com.example.clinic.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class AppointmentDTO {

    private String doctorUsername;

    private LocalDateTime from;

    private LocalDateTime unTill;

    private int duration;

    public AppointmentDTO() {
    }

    public AppointmentDTO(String doctorUsername, LocalDateTime from, LocalDateTime unTill, int duration) {
        this.doctorUsername = doctorUsername;
        this.from = from;
        this.unTill = unTill;
        this.duration = duration;
    }

    public String getDoctorUsername() {
        return doctorUsername;
    }

    public void setDoctorUsername(String doctorUsername) {
        this.doctorUsername = doctorUsername;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getUnTill() {
        return unTill;
    }

    public void setUnTill(LocalDateTime unTill) {
        this.unTill = unTill;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentDTO that = (AppointmentDTO) o;
        return Objects.equals(doctorUsername, that.doctorUsername) &&
                Objects.equals(from, that.from) &&
                Objects.equals(unTill, that.unTill) &&
                Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorUsername, from, unTill, duration);
    }
}
