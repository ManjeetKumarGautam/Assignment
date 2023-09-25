package com.manjeet.UserManagementSystem.repo;

import com.manjeet.UserManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {
    @Autowired
    private List<User> userList;

    public List<User> getUser(){
        return userList;
    }
}
