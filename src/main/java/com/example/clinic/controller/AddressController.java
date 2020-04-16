package com.example.clinic.controller;

import com.example.clinic.domain.Address;
import com.example.clinic.repository.AddressRepository;
import com.example.clinic.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.Optional;

@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/address/get", produces = "application/json")
    public ResponseEntity<Address> getAddress(@RequestParam Long id){
        Optional<Address> address = addressService.retrieveAddressById(id);
        if(address.isPresent()){
            return ResponseEntity.ok(address.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/address/add", consumes = "application/json")
    public ResponseEntity<Long> addAddress(@RequestBody Address address){
        return ResponseEntity.ok(addressService.addAddress(address));
    }

    @PutMapping(value = "/address/update", consumes = "application/json")
    public ResponseEntity<Long> updateAddress(@RequestBody Address address){
        return new ResponseEntity<>(addressService.updateAddress(address), HttpStatus.CREATED);
    }
}
