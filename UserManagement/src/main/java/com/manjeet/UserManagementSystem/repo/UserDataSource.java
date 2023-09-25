package com.manjeet.UserManagementSystem.repo;

import com.manjeet.UserManagementSystem.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserDataSource {
    @Bean
    public List<User> userSource(){
        return new ArrayList<>();
    }
}
