package com.example.RestaurantManagementServiceAPI.service;

import com.example.RestaurantManagementServiceAPI.model.AuthToken;
import com.example.RestaurantManagementServiceAPI.model.dto.AuthInputDto;
import com.example.RestaurantManagementServiceAPI.repo.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    ITokenRepo tokenRepo;
    public void createToken(AuthToken token) {
        tokenRepo.save(token);
    }

    public void deleteToken(String tokenValue) {

        AuthToken token =  tokenRepo.findFirstByTokenValue(tokenValue);
        tokenRepo.delete(token);

    }

    public boolean authenticate(AuthInputDto authInfo) {

        String email = authInfo.getEmail();
        String tokenValue = authInfo.getTokenValue();

        AuthToken token =  tokenRepo.findFirstByTokenValue(tokenValue);
        if(token!=null)
        {
            return token.getUser().getEmail().equals(email);
        }
        else
        {
            return false;
        }

    }
}
