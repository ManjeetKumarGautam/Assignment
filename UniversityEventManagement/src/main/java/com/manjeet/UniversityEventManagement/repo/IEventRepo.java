package com.manjeet.UniversityEventManagement.repo;

import com.manjeet.UniversityEventManagement.model.Event;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface IEventRepo extends CrudRepository<Event, Integer> {

    List<Event> findByDate(LocalDate date);

    @Modifying
    @Query(value = "update event set date=(:date) where event_id=(:id)",nativeQuery = true)
    void updateEventDate(Integer id, LocalDate date);

    @Modifying
    @Query(value = "update event set event_name = (:name) where event_id = (:id)",nativeQuery = true)
    void updateEventName(Integer id, String name);
}
