package com.example.clinic.model.dto.appointment;

import com.example.clinic.domain.Appointment;
import com.example.clinic.domain.Doctor;
import com.example.clinic.repository.DoctorRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AppointmentCreationDTO {

    private String doctorUsername;

    private LocalDateTime from;

    private LocalDateTime to;

    private boolean isCyclic;

    private int duration;


    public AppointmentCreationDTO(String doctorUsername, LocalDateTime from, LocalDateTime to, boolean isCyclic, int duration) {
        this.doctorUsername = doctorUsername;
        this.from = from;
        this.to = to;
        this.isCyclic = isCyclic;
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

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isCyclic() {
        return isCyclic;
    }

    public void setCyclic(boolean cyclic) {
        isCyclic = cyclic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentCreationDTO that = (AppointmentCreationDTO) o;
        return isCyclic == that.isCyclic &&
                duration == that.duration &&
                Objects.equals(doctorUsername, that.doctorUsername) &&
                Objects.equals(from, that.from) &&
                Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorUsername, from, to, isCyclic, duration);
    }
}
