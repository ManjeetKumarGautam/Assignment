package com.example.RestaurantManagementServiceAPI.service;

import com.example.RestaurantManagementServiceAPI.model.FoodItem;
import com.example.RestaurantManagementServiceAPI.model.User;
import com.example.RestaurantManagementServiceAPI.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    public String addUser(User user){
        userRepo.save(user);
        return "Added...";
    }

}
