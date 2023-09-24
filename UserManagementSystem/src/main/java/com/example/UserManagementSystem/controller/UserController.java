package com.example.UserManagementSystem.controller;

import com.example.UserManagementSystem.model.User;
import com.example.UserManagementSystem.repo.IUserRepo;
import com.example.UserManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/users")
    public String addUsers(@RequestBody List<User> userList){
        return userService.addUsers(userList);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/user/id/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }
}
