package com.manjeet.EncompassesHandling.service;

import com.manjeet.EncompassesHandling.model.Address;
import com.manjeet.EncompassesHandling.model.Student;
import com.manjeet.EncompassesHandling.repo.IAddressRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public String addAddress(Address address) {
        addressRepo.save(address);
        return "Added..";
    }

    public Address getAddress(Long id) {
        return addressRepo.findById(id).get();

    }

    @Transactional
    public String updateAddress(Long id, String columnName, String val) {

        if(addressRepo.existsById(id)){
            if(columnName.equals("landmark")){
                addressRepo.updateLandmark(id,val);
            }
            else if(columnName.equals("zipcode")){
                addressRepo.updateZipcode(id,val);
            }
            else if(columnName.equals("district")){
                addressRepo.updateDistrict(id,val);
            }
            else if (columnName.equals("state")) {
                addressRepo.updateState(id,val);
            }
            else if(columnName.equals("country")){
                addressRepo.updateCountry(id,val);
            }
            return "Update...";
        }
        return "Invalid id...";
    }

    public String deleteAddress(Long id) {
        addressRepo.deleteById(id);
        return "Deleted...";
    }
}
