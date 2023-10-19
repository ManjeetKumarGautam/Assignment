package com.manjeet.BasicInstagram.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthInputDto {
    private String email;
    private String tokenValue;
}
