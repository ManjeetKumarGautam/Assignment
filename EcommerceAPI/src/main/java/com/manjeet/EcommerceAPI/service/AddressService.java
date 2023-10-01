package com.manjeet.EcommerceAPI.service;

import com.manjeet.EcommerceAPI.model.Address;
import com.manjeet.EcommerceAPI.repo.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    IAddressRepo addressRepo;

    public String addAddresses(List<Address> addressList){
        addressRepo.saveAll(addressList);
        return "Added...";
    }
}
