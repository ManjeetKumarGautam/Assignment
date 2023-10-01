package com.manjeet.EcommerceAPI.service;

import com.manjeet.EcommerceAPI.model.User;
import com.manjeet.EcommerceAPI.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    public String addUsers(List<User> userList) {
        userRepo.saveAll(userList);
        return "Added...";
    }

    public User getUserById(Integer id){
        return userRepo.findById(id).get();
    }
}
