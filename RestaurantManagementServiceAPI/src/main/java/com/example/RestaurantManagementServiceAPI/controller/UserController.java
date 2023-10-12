package com.example.RestaurantManagementServiceAPI.controller;

import com.example.RestaurantManagementServiceAPI.model.FoodItem;
import com.example.RestaurantManagementServiceAPI.model.Order;
import com.example.RestaurantManagementServiceAPI.model.User;
import com.example.RestaurantManagementServiceAPI.model.dto.AuthInputDto;
import com.example.RestaurantManagementServiceAPI.model.dto.OrderFoodDto;
import com.example.RestaurantManagementServiceAPI.model.dto.SignInInputDto;
import com.example.RestaurantManagementServiceAPI.service.FoodService;
import com.example.RestaurantManagementServiceAPI.service.OrderService;
import com.example.RestaurantManagementServiceAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    FoodService foodService;

    @Autowired
    OrderService orderService;

    @PostMapping("user/signup")
    public String userSignUp(@RequestBody User user)
    {
        return userService.userSignUp(user);
    }

    //sign in
    @PostMapping("user/signIn")
    public String userSignIn(@RequestBody SignInInputDto signInInput)
    {
        return userService.userSignIn(signInInput);
    }

    //sign out
    @DeleteMapping("user/signOut")
    public String userSignOut(@RequestBody AuthInputDto authInfo)
    {
        return userService.userSignOut(authInfo);
    }

    @GetMapping("user/foods")
    public List<FoodItem> getFoods(){
        return foodService.getFoodItems();
    }

    @PostMapping("user/food/order/")
    public String orderFood(@RequestBody OrderFoodDto orderFoodDto)
    {
        return orderService.orderFood(orderFoodDto.getAuthInfo(),orderFoodDto.getOrder());
    }

    @PostMapping("user/orders")
    public List<Order> getOrders(@RequestBody AuthInputDto authInfo){
        return orderService.getOrders(authInfo);
    }
}
