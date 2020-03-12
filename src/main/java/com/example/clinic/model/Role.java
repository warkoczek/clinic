package com.example.clinic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(generator = "Role_Seq")
    @SequenceGenerator(name = "Role_Seq", sequenceName = "role_seq", allocationSize = 50)
    private Long id;

    private String authority;

    public Role(){}

    public Role(String authority){
        this.authority=authority;
    }


}
