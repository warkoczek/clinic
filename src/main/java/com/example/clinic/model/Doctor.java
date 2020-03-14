package com.example.clinic.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Doctor {

    @Id
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    @ManyToOne(targetEntity = Role.class)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private Specialization specialization;

    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(targetEntity = PII.class, cascade = CascadeType.ALL)
    private PII PII;

    public Doctor() {
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

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PII getPII() {
        return PII;
    }

    public void setPII(PII PII) {
        this.PII = PII;
    }
}
