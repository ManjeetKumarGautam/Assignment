package com.example.RestaurantManagementServiceAPI.repo;

import com.example.RestaurantManagementServiceAPI.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order,Integer> {

}
