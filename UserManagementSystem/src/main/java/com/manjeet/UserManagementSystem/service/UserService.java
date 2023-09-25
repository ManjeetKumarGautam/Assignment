package com.manjeet.UserManagementSystem.service;

import com.manjeet.UserManagementSystem.model.User;
import com.manjeet.UserManagementSystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    // add new user......
    public String addUser(User newUser){
        userRepo.getUser().add(newUser);
        return "New user added";
    }

    // add multiple users....
    public String addUsers(List<User> newUserList){
        for(User user:newUserList){
            userRepo.getUser().add(user);
        }
        return "New users added";
    }

    // get user by id......
    public List<User> getUserById(Integer Id){
        List<User> filterUser=new ArrayList<>();

        for(User u: getAllUser()){
            if(u.getUserId().equals(Id)){
                filterUser.add(u);
            }
        }
        return  filterUser;
    }

    // get all user.......
    public List<User> getAllUser(){
        return userRepo.getUser();
    }

    // update info of user
    public String updateUserInfo(Integer Id, String str,String val){

        for(User u: getAllUser()){
            if(u.getUserId().equals(Id)) {
                if (str.equals("userName")) {
                    u.setUserName(val);
                    return  "User "+Id+" user name updated...";
                } else if (str.equals("phoneNumber")) {
                    u.setPhoneNumber(val);
                    return  "User "+Id+" phone number updated...";
                } else if (str.equals("email")) {
                    u.setEmail(val);
                    return  "User "+Id+" email updated...";
                }

            }

        }
        return  "Invalid id";
    }

    // delete user by id
    public String deleteUser(Integer id){
        for(User u: getAllUser()){
            if(u.getUserId().equals(id)){
                getAllUser().remove(u);
                return "User deleted..";
            }
        }
        return "Invalid id..";
    }
}
