package com.example.RestaurantManagementServiceAPI.service;

import com.example.RestaurantManagementServiceAPI.model.FoodItem;
import com.example.RestaurantManagementServiceAPI.repo.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    IFoodRepo foodRepo;


    public List<FoodItem> getFoodItems() {
        return (List<FoodItem>)foodRepo.findAll();
    }

    public String addFood(FoodItem food) {
        foodRepo.save(food);
        return "Food Added...";
    }
}
