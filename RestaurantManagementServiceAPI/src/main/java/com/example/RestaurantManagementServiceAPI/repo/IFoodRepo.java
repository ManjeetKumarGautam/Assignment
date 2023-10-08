package com.example.RestaurantManagementServiceAPI.repo;

import com.example.RestaurantManagementServiceAPI.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodRepo extends JpaRepository<FoodItem,Integer> {
}
