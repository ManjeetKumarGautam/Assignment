package com.example.RestaurantManagementServiceAPI.service;

import com.example.RestaurantManagementServiceAPI.model.User;
import com.example.RestaurantManagementServiceAPI.repo.IUserRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class LoginService {

    @Autowired
    IUserRepo userRepo;

    private boolean flag=false;

    public String signIn(String UsernameOrEmail,String password){

        if(isFlag()){
            return "You are already Login...";
        }

        if(userRepo.existsByUserName(UsernameOrEmail) || userRepo.existsByEmail(UsernameOrEmail)){

            User un= userRepo.findByUserName(UsernameOrEmail).get();
            User ue= userRepo.findByEmail(UsernameOrEmail).get();

            if(un.getPassword().equals(password) || ue.getEmail().equals(password)){
                setFlag(true);
                return "Login Successfully...";
            }
            else {
                return "Incorrect Password...";
            }
        }

//      User login by using email...
//        else if(userRepo.existsByUserName(userOrEmail)){
//
//            User u= userRepo.findByEmail(userOrEmail).get();
//
//            if(u.getPassword().equals(password)){
//                setFlag(true);
//                return "Login Successfully...";
//            }
//            else {
//                return "Incorrect Password...";
//            }
//        }

        return "User does not exist..";
    }

}
