package com.manjeet.EcommerceAPI.service;

import com.manjeet.EcommerceAPI.model.Order;
import com.manjeet.EcommerceAPI.repo.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;

    public String addOrder(List<Order> orderList) {
        orderRepo.saveAll(orderList);
        return "Added...";
    }

    public Order getOrderById(Integer id) {
        return orderRepo.findById(id).get();
    }
}
