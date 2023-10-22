package com.manjeet.ExpenseTrackerAPI.model.dto;

import com.manjeet.ExpenseTrackerAPI.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto {
    AuthDto authInfo;
    Product product;
}
