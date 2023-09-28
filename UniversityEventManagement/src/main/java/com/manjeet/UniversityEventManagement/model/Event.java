package com.manjeet.UniversityEventManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {
    @Id
    @NotNull
    private Integer eventId;

    private String eventName;
    private String eventLocation;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}
