package com.example.RestaurantManagementServiceAPI.repo;

import com.example.RestaurantManagementServiceAPI.model.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthToken, Integer> {
    AuthToken findFirstByTokenValue(String tokenValue);
}
