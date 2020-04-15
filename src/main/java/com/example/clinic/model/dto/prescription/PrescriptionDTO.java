package com.example.clinic.model.dto.prescription;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class PrescriptionDTO {

    private Long prescriptionNumber;

    private LocalDateTime prescriptionIssueDate;

    private LocalDateTime prescriptionExpiryDate;

    private String patientFullName;

    private String doctorFullName;

    private String description;

}
