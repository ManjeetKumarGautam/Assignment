package com.manjeet.ExpenseTrackerAPI.controller;

import com.manjeet.ExpenseTrackerAPI.Service.ProductService;
import com.manjeet.ExpenseTrackerAPI.Service.UserService;
import com.manjeet.ExpenseTrackerAPI.model.User;
import com.manjeet.ExpenseTrackerAPI.model.dto.AuthDto;
import com.manjeet.ExpenseTrackerAPI.model.dto.ExpenseDto;
import com.manjeet.ExpenseTrackerAPI.model.dto.SignInDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @PostMapping("/register")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody SignInDto signInInfo){
        return userService.signIn(signInInfo);
    }

    @PostMapping("/user/product")
    public String addProduct(@RequestBody ExpenseDto expenseDto){
        return productService.addProduct(expenseDto.getAuthInfo(),expenseDto.getProduct());
    }

    @GetMapping("totalExpenditure/{month}")
    public Integer totalExpenditure(@RequestBody AuthDto authInfo, @PathVariable LocalDate month){
        return productService.getTotalExpenditure(authInfo,month);
    }
}
