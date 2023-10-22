package com.manjeet.ExpenseTrackerAPI.repo;

import com.manjeet.ExpenseTrackerAPI.model.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthToken,Integer> {
    AuthToken findFirstByTokenValue(String tokenValue);
}
