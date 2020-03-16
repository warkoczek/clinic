package com.example.clinic.model.dto;

public interface DtoToEntity<D,E> {

    E convertToEntity(D dto);
}
