package com.manjeet.EcommerceAPI.controller;

import com.manjeet.EcommerceAPI.model.User;
import com.manjeet.EcommerceAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("users")
    public String addUser(@RequestBody List<User> userList){
        return userService.addUsers(userList);
    }

    @GetMapping("user/id/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

}
