package com.example.clinic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @OneToOne(targetEntity = PII.class, cascade = CascadeType.ALL)
    private PII PII;

    @OneToOne(targetEntity = Room.class, cascade = CascadeType.PERSIST)
    private Room room;

    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }



}
