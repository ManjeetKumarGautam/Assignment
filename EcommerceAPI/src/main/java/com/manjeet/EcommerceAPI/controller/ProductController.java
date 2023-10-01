package com.manjeet.EcommerceAPI.controller;

import com.manjeet.EcommerceAPI.model.Product;
import com.manjeet.EcommerceAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("products")
    public String addProducts(@RequestBody List<Product> productList){
        return productService.addProducts(productList);
    }

    @GetMapping("products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("products/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category){
        return productService.getProductsByCategory(category);
    }

    @DeleteMapping("product/id/{id}")
    public String deleteProductById(@PathVariable Integer id){
        return productService.deleteProductById(id);
    }
}
