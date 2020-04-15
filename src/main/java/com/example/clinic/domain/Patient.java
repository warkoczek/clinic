package com.example.clinic.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Patient {

    @Id
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    @ManyToOne(targetEntity = Role.class)
    private Role role;

    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(targetEntity = PII.class, cascade = CascadeType.ALL)
    private PII pii;


    public String getFullName(){
        return getFirstName() + " " +getLastName();
    }


    public Patient() {
    }
    public Patient(String username, String password, String firstName, String lastName, Role role, Address address, PII pii){
        this.username=username;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
        this.role=role;
        this.address=address;
        this.pii=pii;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PII getPII() {
        return pii;
    }

    public void setPII(PII PII) {
        this.pii = pii;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(username, patient.username) &&
                Objects.equals(password, patient.password) &&
                Objects.equals(firstName, patient.firstName) &&
                Objects.equals(lastName, patient.lastName) &&
                Objects.equals(role, patient.role) &&
                Objects.equals(address, patient.address) &&
                Objects.equals(pii, patient.pii);

    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName, role, address, pii);
    }
}
