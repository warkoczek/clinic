package com.example.clinic.service;

import com.example.clinic.domain.Address;
import com.example.clinic.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

   /* public void addAddress(Address address){
        addressRepository.findAllByCityAndPostCodeAndStreet(address.getCity(), address.getPostCode(), address.getStreet())
                .stream()
                .

    }*/
}
