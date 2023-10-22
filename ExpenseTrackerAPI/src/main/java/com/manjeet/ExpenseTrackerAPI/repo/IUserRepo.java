package com.manjeet.ExpenseTrackerAPI.repo;

import com.manjeet.ExpenseTrackerAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByEmail(String newEmail);
}
