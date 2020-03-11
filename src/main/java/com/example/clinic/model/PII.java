package com.example.clinic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class PII {

    @Id
    private String idNumber;

    private String phoneNumber;
    private String emailAddress;

}
