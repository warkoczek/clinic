package com.example.clinic.repository;

import com.example.clinic.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Set<Address> findAllByCityAndPostCodeAndStreet(String city, String postCode, String street);


}
