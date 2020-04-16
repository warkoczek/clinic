package com.example.clinic.service;

import com.example.clinic.domain.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Before
    public Address createAddress(){
        return new Address("George Street", "12", "90890", "Kalisz");
    }

    @Test
    void addAddressShouldReturnIndex8ForAddedAddress() {
        //given
        Long expectedAddressIndex = 8L;
        //when
        Long actualAddressIndex = addressService.addAddress(createAddress());
        //then
        Assert.assertEquals(expectedAddressIndex, actualAddressIndex);
    }

    @Test
    void getAddressShouldReturnAddressWithHouseNumber12ForAddressId1(){
        //given
        Long addressId = 1L;
        String expectedHouseNumber = "11";
        //when
        String actualHouseNumber = addressService.retrieveAddressById(addressId).get().getHouseNumber();
        //then
        Assert.assertEquals(expectedHouseNumber, actualHouseNumber);
    }


}
