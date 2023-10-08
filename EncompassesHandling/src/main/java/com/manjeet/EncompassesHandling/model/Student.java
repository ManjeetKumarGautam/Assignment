package com.manjeet.EncompassesHandling.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Student.class, property = "id")
public class Student {

    @Id
    private String id;

    private String name;
    private String age;

    @Size(min = 10,max = 10)
    private String phoneNumber;
    private String branch;
    private String department;

    @OneToOne
    @JoinColumn(name = "fk_address_id")
    private Address address;

    @OneToMany
    @JoinColumn(name = "fk_courses_id")
    private Set<Course> courseSet;

    @OneToMany
    @JoinColumn(name = "fk_books_id")
    private Set<Book> bookSet;

    @OneToOne
    @JoinColumn(name = "fk_laptop_id")
    private Laptop laptop;
}
