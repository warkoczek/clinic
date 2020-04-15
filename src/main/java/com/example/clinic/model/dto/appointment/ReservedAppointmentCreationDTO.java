package com.example.clinic.model.dto.appointment;

import lombok.NoArgsConstructor;

//created from available appointment plus DTO data
@NoArgsConstructor
public class ReservedAppointmentCreationDTO {

    private Long appointmentId;
    private String patientUsername;
    private String description;

    public ReservedAppointmentCreationDTO(Long appointmentId, String patientUsername, String description) {
        this.appointmentId = appointmentId;
        this.patientUsername = patientUsername;
        this.description = description;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientUsername() {
        return patientUsername;
    }

    public void setPatientUsername(String patientUsername) {
        this.patientUsername = patientUsername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
