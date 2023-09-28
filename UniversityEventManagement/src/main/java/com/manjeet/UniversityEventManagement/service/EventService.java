package com.manjeet.UniversityEventManagement.service;

import com.manjeet.UniversityEventManagement.model.Event;
import com.manjeet.UniversityEventManagement.repo.IEventRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class EventService {
    @Autowired
    IEventRepo eventRepo;

    public String addEvents(List<Event> eventList) {
        eventRepo.saveAll(eventList);
        return "Added...";
    }

    public String deleteEventById(Integer id) {
        eventRepo.deleteById(id);
        return "Deleted...";
    }

    public List<Event> getEventsByDate(LocalDate date) {
        return eventRepo.findByDate(date);
    }

    @Transactional
    public String updateEventDateById(Integer id, LocalDate date) {
        eventRepo.updateEventDate(id,date);
        return "Updated...";
    }

    @Transactional
    public String updateEventNameById(Integer id, String name) {
        eventRepo.updateEventName(id,name);
        return "Updated...";
    }
}
