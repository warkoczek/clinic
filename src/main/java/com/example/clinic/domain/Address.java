package com.example.clinic.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(street, address.street) &&
                Objects.equals(houseNumber, address.houseNumber) &&
                Objects.equals(postCode, address.postCode) &&
                Objects.equals(city, address.city) &&
                Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, houseNumber, postCode, city, country);
    }
}
