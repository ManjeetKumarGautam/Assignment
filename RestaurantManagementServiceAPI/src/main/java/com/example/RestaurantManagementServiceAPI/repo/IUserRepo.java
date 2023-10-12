package com.example.RestaurantManagementServiceAPI.repo;

import com.example.RestaurantManagementServiceAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepo extends JpaRepository<User,Integer> {


    User findFirstByEmail(String newEmail);
}
