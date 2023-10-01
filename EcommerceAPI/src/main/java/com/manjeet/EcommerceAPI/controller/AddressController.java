package com.manjeet.EcommerceAPI.controller;

import com.manjeet.EcommerceAPI.model.Address;
import com.manjeet.EcommerceAPI.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("addresses")
    public String addAddress(@RequestBody List<Address> addressList){
        return addressService.addAddresses(addressList);
    }
}
