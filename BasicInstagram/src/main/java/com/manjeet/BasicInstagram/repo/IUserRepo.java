package com.manjeet.BasicInstagram.repo;

import com.manjeet.BasicInstagram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {

    User findFirstByEmail(String email);
}
