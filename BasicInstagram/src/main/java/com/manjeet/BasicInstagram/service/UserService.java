package com.manjeet.BasicInstagram.service;

import com.manjeet.BasicInstagram.model.AuthToken;
import com.manjeet.BasicInstagram.model.User;
import com.manjeet.BasicInstagram.model.dto.AuthInputDto;
import com.manjeet.BasicInstagram.model.dto.SignInInputDto;
import com.manjeet.BasicInstagram.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    TokenService tokenService;


    public String signUp(User user) {

        String newEmail=user.getEmail();

        User existEmail=userRepo.findFirstByEmail(newEmail);

        if(existEmail != null){
            return "Email already in use, Please try to SignIn";
        }

        String password = user.getPassword();

        try{
            String ep= Encryptor.encrypt(password);
            user.setPassword(ep);

            userRepo.save(user);
            return "Signup Successfully...";

        } catch (NoSuchAlgorithmException e) {
            return "Internal Server issues while saving password, try again later...";
        }

    }

    public String signIn(SignInInputDto signInInput) {

        String email = signInInput.getEmail();

        User existingUser = userRepo.findFirstByEmail(email);

        if(existingUser == null)
        {
            return "Not a valid email, Please sign up first !!!";
        }

        //password should be matched

        String password = signInInput.getPassword();

        try {
            String encryptedPassword = Encryptor.encrypt(password);

            if(existingUser.getPassword().equals(encryptedPassword))
            {
                // return a token for this sign in
                AuthToken token  = new AuthToken(existingUser);
                tokenService.createToken(token);

                return token.getToken();
            }
            else {
                //password was wrong!!!
                return "Invalid Credentials!!!";
            }

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }


    }

    public String updateUser(AuthInputDto authInfo, String columnName, String value) {
       return "update";
    }
}
