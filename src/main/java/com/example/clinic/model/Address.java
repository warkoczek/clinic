package com.example.clinic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(generator = "addressSeq")
    @SequenceGenerator(name = "addressSeq", sequenceName = "address_seq", allocationSize = 50)
    private Long id;

    private String street;
    private String houseNumber;
    private String postCode;
    private String city;
    private String country;
}
