package com.manjeet.BasicInstagram.repo;

import com.manjeet.BasicInstagram.model.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthToken, Long> {
    AuthToken findFirstByTokenValue(String tokenValue);
}
