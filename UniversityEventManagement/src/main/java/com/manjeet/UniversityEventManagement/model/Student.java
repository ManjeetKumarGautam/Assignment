package com.manjeet.UniversityEventManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @NotNull
    private Long studentId;

    @Pattern(regexp = "^[A-Z][a-z]*$")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-z]*$")
    private String lastName;

    @Min(18)
    @Max(25)
    private int age;

    @Enumerated(EnumType.STRING)
    private Department department;
}
