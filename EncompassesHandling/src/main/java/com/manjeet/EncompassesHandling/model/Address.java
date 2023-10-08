package com.manjeet.EncompassesHandling.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    private Long addressId;
    private String landmark;
    private String zipcode;
    private String district;
    private String state;
    private String country;

    @OneToOne
    Student student;
}
