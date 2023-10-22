package com.manjeet.ExpenseTrackerAPI.repo;

import com.manjeet.ExpenseTrackerAPI.model.Product;
import com.manjeet.ExpenseTrackerAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IProductRepo extends JpaRepository<Product,Integer> {

    List<Product> findByUser(User user);
}
