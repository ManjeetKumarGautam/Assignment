package com.manjeet.EncompassesHandling.Controller;

import com.manjeet.EncompassesHandling.model.Address;
import com.manjeet.EncompassesHandling.model.Student;
import com.manjeet.EncompassesHandling.service.AddressService;
import com.manjeet.EncompassesHandling.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping
    public String addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @GetMapping("/id/{id}")
    public Address getAddressById(@PathVariable Long id){
        return addressService.getAddress(id);
    }

    @PutMapping("/id/{id}")
    public String updateAddress(@PathVariable Long id,@RequestParam String columnName,@RequestParam String val){
        return addressService.updateAddress(id,columnName,val);
    }

    @DeleteMapping("/id/{id}")
    public  String deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }
}
