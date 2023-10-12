package com.example.RestaurantManagementServiceAPI.service;

import com.example.RestaurantManagementServiceAPI.model.AuthToken;
import com.example.RestaurantManagementServiceAPI.model.User;
import com.example.RestaurantManagementServiceAPI.model.dto.AuthInputDto;
import com.example.RestaurantManagementServiceAPI.model.dto.SignInInputDto;
import com.example.RestaurantManagementServiceAPI.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.*;

@Service
public class AdminService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    TokenService tokenService;



    public String adminSignUp(User user) {

        String newEmail = user.getEmail();

        User existingUser = userRepo.findFirstByEmail(newEmail);

        if(existingUser != null)
        {
            return "email already in use";
        }

        // passwords are encrypted before we store it in the table

        String signUpPassword = user.getPassword();

        try {
            String encryptedPassword = PasswordEncrypt.encrypt(signUpPassword);

            user.setPassword(encryptedPassword);


            // User table - save User
            userRepo.save(user);
            return "User registered";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }

    }

    public String adminSignIn(SignInInputDto signInInput) {

        String email = signInInput.getEmail();
        String EMAIL_REGEX= "^[a-zA-Z0-9._%+-]+@admin\\.com$";

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        if(!matcher.matches()){
            return "Not a valid email, Please login with admin Id ...";
        }

        User existingUser = userRepo.findFirstByEmail(email);

        if(existingUser == null)
        {
            return "Not a valid email, Please sign up first !!!";
        }

        //password should be matched

        String password = signInInput.getPassword();

        try {
            String encryptedPassword = PasswordEncrypt.encrypt(password);

            if(existingUser.getPassword().equals(encryptedPassword))
            {
                // return a token for this sign in
                AuthToken token  = new AuthToken(existingUser);
                tokenService.createToken(token);
                return token.getTokenValue();

            }
            else {
                //password was wrong!!!
                return "Invalid Credentials!!!";
            }

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }


    }

    public String adminSignOut(AuthInputDto authInfo) {

        if(tokenService.authenticate(authInfo)) {
            String tokenValue = authInfo.getTokenValue();
            tokenService.deleteToken(tokenValue);
            return "Sign Out successful!!";
        }
        else {
            return "Unauthenticated access!!!";
        }

    }

}
