package com.example.clinic.model;

import lombok.Data;

@Data
public class Address {

    private Long id;
    private String street;
    private String houseNumber;
    private String postCode;
    private String city;
    private String country;
}
