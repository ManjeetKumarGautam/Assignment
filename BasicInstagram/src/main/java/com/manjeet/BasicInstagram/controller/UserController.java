package com.manjeet.BasicInstagram.controller;

import com.manjeet.BasicInstagram.model.User;
import com.manjeet.BasicInstagram.model.dto.AuthInputDto;
import com.manjeet.BasicInstagram.model.dto.SignInInputDto;
import com.manjeet.BasicInstagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("signUp")
    public String signUp(@RequestBody User user){
        return userService.signUp(user);
    }

    @PostMapping("signIn")
    public String signIn(@RequestBody SignInInputDto signInInput){
        return userService.signIn(signInInput);
    }

    @PutMapping("user/{columnName}/{value}")
    public String updateUser(@RequestBody AuthInputDto authInfo, @PathVariable String columnName,@PathVariable String value){
        return userService.updateUser(authInfo,columnName,value);
    }

}
