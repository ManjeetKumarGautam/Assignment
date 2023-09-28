package com.manjeet.UniversityEventManagement.controller;

import com.manjeet.UniversityEventManagement.model.Event;
import com.manjeet.UniversityEventManagement.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@Validated
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("events")
    public String  addEvents(@RequestBody @Valid List<Event> eventList){
        return eventService.addEvents(eventList);
    }

    @PutMapping("event/id/{id}/date/{date}")
    public String updateEventDateById(@PathVariable Integer id,@PathVariable LocalDate date){
        return eventService.updateEventDateById(id,date);
    }

    @DeleteMapping("event/id/{id}")
    public String deleteEventById(@PathVariable Integer id){
        return eventService.deleteEventById(id);
    }

    @GetMapping("event/date/{date}")
    public  List<Event> getEventsByDate(@PathVariable LocalDate date){
        return eventService.getEventsByDate(date);
    }

    @PutMapping("event/id/{id}/eventName/{name}")
    public String updateEventNameById(Integer id, String name) {
        return eventService.updateEventNameById(id,name);
    }
}
