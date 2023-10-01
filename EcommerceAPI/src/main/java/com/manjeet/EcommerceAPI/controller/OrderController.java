package com.manjeet.EcommerceAPI.controller;

import com.manjeet.EcommerceAPI.model.Order;
import com.manjeet.EcommerceAPI.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("orders")
    public String addOrder(@RequestBody List<Order> orderList){
        return orderService.addOrder(orderList);
    }

    @GetMapping("order/id/{id}")
    public Order getOrderById(@PathVariable Integer id){
        return orderService.getOrderById(id);
    }
}
