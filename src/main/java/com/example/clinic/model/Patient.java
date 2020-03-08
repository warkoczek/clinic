package com.example.clinic.model;

import java.util.Objects;

public class Patient {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private Role role;

    private Address address;

    private PersonalData personalData;

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

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
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
                Objects.equals(personalData, patient.personalData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName, role, address, personalData);
    }
}
