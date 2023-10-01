package com.manjeet.EcommerceAPI.service;

import com.manjeet.EcommerceAPI.model.Product;
import com.manjeet.EcommerceAPI.repo.IProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepo productRepo;

    @Transactional
    public String addProducts(List<Product> productList) {
        productRepo.saveAll(productList);
        return "Added...";
    }

    public List<Product> getProducts() {
        return (List<Product>)productRepo.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepo.getProductsByCategory(category);
    }

    public String deleteProductById(Integer id) {
        productRepo.deleteById(id);
        return "Deleted...";
    }
}
