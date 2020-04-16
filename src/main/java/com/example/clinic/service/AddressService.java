package com.example.clinic.service;

import com.example.clinic.domain.Address;
import com.example.clinic.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Optional<Address> retrieveAddressById(Long id){
        return addressRepository.findById(id);
    }

    public Long addAddress(Address address) {

        addressRepository.save(address);

        return address.getId();
    }

    public Long updateAddress(Address address){
        Optional<Address> toUpdate = addressRepository.findAddressById(address.getId());

        if(toUpdate.isPresent()){
            addressRepository.delete(toUpdate.get());
        }
        addressRepository.save(address);

        return address.getId();
    }
}
