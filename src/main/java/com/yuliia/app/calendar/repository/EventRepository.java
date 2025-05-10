package com.yuliia.app.calendar.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yuliia.app.calendar.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> { }

