package com.manjeet.EmployeeAddress.service;

import com.manjeet.EmployeeAddress.model.Address;
import com.manjeet.EmployeeAddress.repo.IAddressRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public List<Address> getAddresses() {
        return (List<Address>)addressRepo.findAll();
    }

    public Address getAddress(Long id) {
        return addressRepo.findById(id).get();
    }

    public String addAddress(Address address) {
        addressRepo.save(address);
        return "Added...";
    }

    @Transactional
    public String updateAddress(Long id, String columnName, String val) {
        if(addressRepo.existsById(id)){
            if(columnName.equals("street")){
                addressRepo.updateStreet(val,id);
                return columnName+" updated...";
            }
            else if(columnName.equals("city")){
                addressRepo.updateCity(val,id);
                return columnName+" updated...";
            }
            else if(columnName.equals("state")){
                addressRepo.updateState(val,id);
                return columnName+" updated...";
            }
            else if(columnName.equals("zipcode")){
                addressRepo.updateZipcode(val,id);
                return columnName+" updated...";
            }
            else {
                return "Column name not found...";
            }

        }
        return "Invalid Id";
    }

    public String deleteAddress(Long id) {
        addressRepo.deleteById(id);
        return "Deleted...";
    }
}
