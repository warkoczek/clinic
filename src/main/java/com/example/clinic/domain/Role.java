package com.example.clinic.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(generator = "roleSeq")
    @SequenceGenerator(name = "roleSeq", sequenceName = "role_Seq", allocationSize = 1)
    private Long id;

    private String authority;

    public Role(){}

    public Role(String authority){
        this.authority=authority;
    }


}
