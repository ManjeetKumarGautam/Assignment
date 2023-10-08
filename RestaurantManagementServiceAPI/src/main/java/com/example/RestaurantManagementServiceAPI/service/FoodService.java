package com.example.RestaurantManagementServiceAPI.service;

import com.example.RestaurantManagementServiceAPI.model.FoodItem;
import com.example.RestaurantManagementServiceAPI.repo.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FoodService {
    @Autowired
    IFoodRepo foodRepo;


    public List<FoodItem> getFoodItems() {
        return (List<FoodItem>)foodRepo.findAll();
    }
}
