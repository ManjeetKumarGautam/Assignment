package com.manjeet.EncompassesHandling.service;

import com.manjeet.EncompassesHandling.model.Laptop;
import com.manjeet.EncompassesHandling.repo.ILaptopRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    @Autowired
    ILaptopRepo laptopRepo;

    public String addLaptop(Laptop laptop) {
        laptopRepo.save(laptop);
        return "Added...";
    }

    public Laptop getLaptop(String id) {
        return laptopRepo.findById(id).get();
    }

    @Transactional
    public String updateLaptop(String id, String columnName, String val) {
        if(laptopRepo.existsById(id)){
            if(columnName.equals("name")){
                laptopRepo.updateName(id,val);
            }
            else if(columnName.equals("brand")){
                laptopRepo.updateBrand(id,val);
            }
            else if (columnName.equals("price")) {
                laptopRepo.updatePrice(id,val);
            }

            return "Update...";
        }
        return "Invalid id...";
    }

    public String deleteLaptop(String id) {
        laptopRepo.deleteById(id);
        return "Deleted...";
    }
}
