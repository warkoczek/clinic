package com.example.clinic.model.dto;

import org.modelmapper.TypeMap;



public interface EntityToDto {

     <T, G> TypeMap<T, G> getTypeMap();


}
