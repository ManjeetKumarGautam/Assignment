package com.example.RestaurantManagementServiceAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "fk_food_id")
    FoodItem foodItem;

    private int qty;

    @OneToMany
    @JoinColumn(name = "fk_user_id")
    User user;

    private LocalDateTime dateTime;

    private Status status;

}
