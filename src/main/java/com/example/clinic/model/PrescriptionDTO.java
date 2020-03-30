package com.example.clinic.model;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class PrescriptionDTO {

    private Long prescriptionNumber;

    private LocalDateTime PrescriptionIssueDate;

    private String patientFullName;

    private String doctorFullName;

    private String description;

}
