package com.manjeet.ExpenseTrackerAPI.Service;

import com.manjeet.ExpenseTrackerAPI.model.Product;
import com.manjeet.ExpenseTrackerAPI.model.User;
import com.manjeet.ExpenseTrackerAPI.model.dto.AuthDto;
import com.manjeet.ExpenseTrackerAPI.model.dto.ExpenseDto;
import com.manjeet.ExpenseTrackerAPI.repo.IProductRepo;
import com.manjeet.ExpenseTrackerAPI.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    TokenService tokenService;

    @Autowired
    IUserRepo userRepo;

    @Autowired
    IProductRepo productRepo;
    public String addProduct(AuthDto authInfo, Product product){
        if(tokenService.authenticate(authInfo)){
            String email= authInfo.getEmail();
            User user= userRepo.findFirstByEmail(email);

            product.setUser(user);

            if(user!=null){
                product.setDate(LocalDate.now());
                product.setTime(LocalTime.now());
                productRepo.save(product);
                return "Product Added...";
            }
            else {
                return "User dose not exist...";
            }
        }
        else {
            return "Un Authenticated access...";
        }
    }

    public Integer getTotalExpenditure(AuthDto authInfo, LocalDate month) {

        if(tokenService.authenticate(authInfo)){

            User user = userRepo.findFirstByEmail(authInfo.getEmail());

            List<Product> productList = productRepo.findByUser(user);

            Integer expenditure=0;
            for (Product product : productList){
                if(product.getDate().getYear()==month.getYear() && product.getDate().getMonthValue()==month.getMonthValue() )
                    expenditure=expenditure+product.getPrice();
            }
            return expenditure;
        }
        else {
            return 0;
        }
    }
}
