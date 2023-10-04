package com.manjeet.EmployeeAddress.controller;

import com.manjeet.EmployeeAddress.model.Address;
import com.manjeet.EmployeeAddress.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("addresses")
    public List<Address> getAddresses(){
        return addressService.getAddresses();
    }

    @GetMapping("address/{id}")
    public Address getAddress(@PathVariable Long id){
        return addressService.getAddress(id);
    }

    @PostMapping("address")
    public String addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @PutMapping("addresses/{id}/{columnName}={val}")
    public String updateAddress(@PathVariable Long id, @PathVariable String columnName,@PathVariable String val){
        return addressService.updateAddress(id,columnName,val);
    }

    @DeleteMapping("address/{id}")
    public String deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }
}