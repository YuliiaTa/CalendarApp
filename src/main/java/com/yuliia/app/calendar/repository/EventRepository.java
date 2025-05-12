package com.yuliia.app.calendar.repository;

import com.yuliia.app.calendar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
    List<Event> findByDate(LocalDate date);
    List<Event> findByOwnerId(UUID ownerId);
    List<Event> findByOwnerIdAndDate(UUID ownerId, LocalDate date);
}
