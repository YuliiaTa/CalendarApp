package com.yuliia.app.calendar.repository;

import com.yuliia.app.calendar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
    List<Event> findByDate(String date);
    List<Event> findByOwnerId(UUID ownerId);
    List<Event> findByOwnerIdAndDate(UUID ownerId, String date);
}