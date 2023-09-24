package com.example.UserManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    private Integer userId;
    private String userName;
    private LocalDate userDOB;
    private String email;
    private String phoneNumber;
    private LocalDate date;
    private LocalTime time;
}
