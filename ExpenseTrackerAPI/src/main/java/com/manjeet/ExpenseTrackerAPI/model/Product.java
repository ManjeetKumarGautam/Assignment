package com.manjeet.ExpenseTrackerAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    private Integer id;
    private String title;
    private String description;
    private Integer price;
    private LocalDate date;

    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    User user;
}
