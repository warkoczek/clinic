package com.example.clinic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class PII {

    @Id
    private String idNumber;

    private String phoneNumber;
    private String emailAddress;

    public PII() {
    }

    public PII(String idNumber,String phoneNumber, String emailAddress){
        this.idNumber=idNumber;
        this.phoneNumber=phoneNumber;
        this.emailAddress=emailAddress;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PII pii = (PII) o;
        return Objects.equals(idNumber, pii.idNumber) &&
                Objects.equals(phoneNumber, pii.phoneNumber) &&
                Objects.equals(emailAddress, pii.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, phoneNumber, emailAddress);
    }
}
