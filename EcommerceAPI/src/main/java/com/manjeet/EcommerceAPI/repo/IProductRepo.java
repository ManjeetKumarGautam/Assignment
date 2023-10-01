package com.manjeet.EcommerceAPI.repo;

import com.manjeet.EcommerceAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductRepo extends JpaRepository<Product,Integer> {

    @Modifying
    @Query(value = "Select * from product where category= :category", nativeQuery = true)
    List<Product> getProductsByCategory(String category);
}
