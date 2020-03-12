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
    @SequenceGenerator(name = "addressSeq", sequenceName = "address_seq", allocationSize = 1)
    private Long id;

    private String street;
    private String houseNumber;
    private String postCode;
    private String city;
    private String country;

    public Address() {
    }

    public Address(String street, String houseNumber, String postCode, String city, String country){
        this.street=street;
        this.houseNumber=houseNumber;
        this.postCode=postCode;
        this.city=city;
        this.country=country;
    }
}
