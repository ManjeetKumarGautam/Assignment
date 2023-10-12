package com.example.RestaurantManagementServiceAPI.controller;

import com.example.RestaurantManagementServiceAPI.model.FoodItem;
import com.example.RestaurantManagementServiceAPI.model.User;
import com.example.RestaurantManagementServiceAPI.model.dto.AuthInputDto;
import com.example.RestaurantManagementServiceAPI.model.dto.SignInInputDto;
import com.example.RestaurantManagementServiceAPI.service.AdminService;
import com.example.RestaurantManagementServiceAPI.service.FoodService;
import com.example.RestaurantManagementServiceAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    FoodService foodService;

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @PostMapping("admin/signup")
    public String adminSignUp(@RequestBody User user)
    {
        return adminService.adminSignUp(user);
    }

    //sign in
    @PostMapping("admin/signIn")
    public String adminSignIn(@RequestBody SignInInputDto signInInput)
    {
        return adminService.adminSignIn(signInInput);
    }

    //sign out
    @DeleteMapping("admin/signOut")
    public String adminSignOut(@RequestBody AuthInputDto authInfo)
    {
        return adminService.adminSignOut(authInfo);
    }

    @GetMapping("admin/foods")
    public List<FoodItem> getFoods(){
        return foodService.getFoodItems();
    }

    @PostMapping("admin/foods")
    public String addFood(@RequestBody FoodItem food){
        return foodService.addFood(food);
    }

    @GetMapping("admin/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
