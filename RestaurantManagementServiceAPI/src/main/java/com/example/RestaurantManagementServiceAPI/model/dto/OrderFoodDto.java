package com.example.RestaurantManagementServiceAPI.model.dto;

import com.example.RestaurantManagementServiceAPI.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderFoodDto {

    AuthInputDto authInfo;
    Order order;
}
