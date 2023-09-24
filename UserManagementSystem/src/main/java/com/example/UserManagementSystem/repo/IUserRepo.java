package com.example.UserManagementSystem.repo;

import com.example.UserManagementSystem.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends CrudRepository <User,Integer>{
}
