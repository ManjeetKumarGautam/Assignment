package com.manjeet.UserManagementSystem.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotNull
    private Integer userId;

    @Pattern(regexp = "^[A-Za-z-' ]+$")
    @Size(min =3)
    private String userName;

// by default, it is store like this pattern yyyy-mm-dd
    private LocalDate userDOB;

    @Email
    private String email;

    @Pattern(regexp = "^\\+\\d{2}\\d{10}$") //+919876543210
    private String phoneNumber;

    private LocalDate date;

    private LocalTime time;
}
