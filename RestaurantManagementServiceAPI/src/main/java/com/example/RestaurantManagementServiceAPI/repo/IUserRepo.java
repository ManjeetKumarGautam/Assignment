package com.example.RestaurantManagementServiceAPI.repo;

import com.example.RestaurantManagementServiceAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepo extends JpaRepository<User,Integer> {

    boolean existsByUserName(String username);

    boolean existsByEmail(String email);

    Optional<User> findByUserName(String userName);

    Optional<User> findByEmail(String userEmail);


}
