package com.example.RestaurantManagementServiceAPI.controller;

import com.example.RestaurantManagementServiceAPI.model.FoodItem;
import com.example.RestaurantManagementServiceAPI.model.User;
import com.example.RestaurantManagementServiceAPI.service.FoodService;
import com.example.RestaurantManagementServiceAPI.service.LoginService;
import com.example.RestaurantManagementServiceAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @Autowired
    FoodService foodService;

    @PostMapping("/signUp")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/signIn/{username}/{password}")
    public  String signInUser(@PathVariable String username,@PathVariable String password){
        return loginService.signIn(username,password);
    }

    @GetMapping("/foods/")
    public List<FoodItem> getFoods(){
        return foodService.getFoodItems();
    }

}
