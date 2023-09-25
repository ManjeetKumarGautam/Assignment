package com.manjeet.UserManagementSystem.controller;

import com.manjeet.UserManagementSystem.model.User;
import com.manjeet.UserManagementSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userService;

    // add a new user
    @PostMapping("user")
    public String addUser(@RequestBody @Valid User newUser){
        return userService.addUser(newUser);
    }
    // add multiple user
    @PostMapping("users")
    public String addUsers(@RequestBody @Valid List<User> newUserList){
        return userService.addUsers(newUserList);
    }

    // get all user
    @GetMapping("users")
    public List<User> getUsers(){
        return userService.getAllUser();
    }

    // get user by id
    @GetMapping("user/id/{id}")
    public List<User> getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    //update user info
    @PutMapping("user/info/{id}/{str}/{val}")
    public String updateUser(@PathVariable @Valid Integer id,@PathVariable String str, @PathVariable String val){
        return userService.updateUserInfo(id,str,val);
    }

    // delete user by id
    @DeleteMapping("user/id/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
