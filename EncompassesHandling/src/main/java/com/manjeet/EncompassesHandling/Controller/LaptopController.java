package com.manjeet.EncompassesHandling.Controller;

import com.manjeet.EncompassesHandling.model.Course;
import com.manjeet.EncompassesHandling.model.Laptop;
import com.manjeet.EncompassesHandling.service.CourseService;
import com.manjeet.EncompassesHandling.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @PostMapping
    public String addLaptop(@RequestBody Laptop laptop){
        return laptopService.addLaptop(laptop);
    }

    @GetMapping("/id/{id}")
    public Laptop getLaptopById(@PathVariable String id){
        return laptopService.getLaptop(id);
    }

    @PutMapping("/id/{id}")
    public String updateLaptop(@PathVariable String id,@RequestParam String columnName,@RequestParam String val){
        return laptopService.updateLaptop(id,columnName,val);
    }

    @DeleteMapping("/id/{id}")
    public  String deleteLaptop(@PathVariable String id){
        return laptopService.deleteLaptop(id);
    }

}
