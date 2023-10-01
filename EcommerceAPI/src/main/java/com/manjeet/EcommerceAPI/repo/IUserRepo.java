package com.manjeet.EcommerceAPI.repo;

import com.manjeet.EcommerceAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {

}
