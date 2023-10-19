package com.manjeet.BasicInstagram.service;

import com.manjeet.BasicInstagram.model.AuthToken;
import com.manjeet.BasicInstagram.model.dto.AuthInputDto;
import com.manjeet.BasicInstagram.repo.ITokenRepo;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    ITokenRepo tokenRepo;

    public void createToken(AuthToken token) {
        tokenRepo.save(token);
    }

    public Integer getUserIdByToken(String tokenValue) {

        AuthToken token =  tokenRepo.findFirstByTokenValue(tokenValue);
        return token.getUser().getId();
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
