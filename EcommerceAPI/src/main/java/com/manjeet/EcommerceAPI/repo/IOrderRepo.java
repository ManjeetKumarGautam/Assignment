package com.manjeet.EcommerceAPI.repo;

import com.manjeet.EcommerceAPI.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IOrderRepo extends JpaRepository<Order,Integer> {
}
