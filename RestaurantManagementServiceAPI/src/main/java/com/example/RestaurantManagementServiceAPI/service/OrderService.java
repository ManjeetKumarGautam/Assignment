package com.example.RestaurantManagementServiceAPI.service;

import com.example.RestaurantManagementServiceAPI.model.FoodItem;
import com.example.RestaurantManagementServiceAPI.model.Order;
import com.example.RestaurantManagementServiceAPI.model.User;
import com.example.RestaurantManagementServiceAPI.model.dto.AuthInputDto;
import com.example.RestaurantManagementServiceAPI.repo.IFoodRepo;
import com.example.RestaurantManagementServiceAPI.repo.IOrderRepo;
import com.example.RestaurantManagementServiceAPI.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    IOrderRepo orderRepo;

    @Autowired
    IUserRepo userRepo;

    @Autowired
    IFoodRepo foodRepo;

    @Autowired
    TokenService tokenService;

    public String orderFood(AuthInputDto authInfo, Order order) {

        if(tokenService.authenticate(authInfo)) {

            //find thr user
            String email = authInfo.getEmail();

            User user = userRepo.findFirstByEmail(email);

            order.setUser(user);


            //find the Food

            Integer foodId = order.getFoodItem().getFoodId();

            FoodItem food = foodRepo.findById(foodId).orElseThrow();

            order.setFoodItem(food);


            if(food != null)
            {
                order.setDateTime(LocalDateTime.now());
                orderRepo.save(order);
                return "Food ordered at time :" + order.getDateTime();
            }
            else
            {
                return "Doctor does not exist, Could not book order!!!";
            }
        }
        else {
            return "Un Authenticated access!!!";
        }
    }

    public List<Order> getOrders(AuthInputDto authInfo) {
        if(tokenService.authenticate(authInfo)) {
            return orderRepo.findAll();
        }
        else {
            return null;
        }
    }
}
