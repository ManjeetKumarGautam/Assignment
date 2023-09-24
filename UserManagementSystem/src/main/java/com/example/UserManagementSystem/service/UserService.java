package com.example.UserManagementSystem.service;

import com.example.UserManagementSystem.model.User;
import com.example.UserManagementSystem.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    public String addUsers(List<User> userList) {
        userRepo.saveAll(userList);
        return "New "+userList.size()+" were added..." ;
    }

    public List<User> getAllUser() {
        return (List<User>)userRepo.findAll();
    }

    public List<User> getUser(Integer id) {
         return userRepo.findById(id);
    }
}
