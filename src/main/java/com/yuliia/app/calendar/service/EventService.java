package com.yuliia.app.calendar.service;

import com.yuliia.app.calendar.model.Event;
import com.yuliia.app.calendar.model.User;
import com.yuliia.app.calendar.repository.EventRepository;
import com.yuliia.app.calendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Transactional
    public Event saveEvent(Event event, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        event.setOwner(user);
        return eventRepository.save(event);
    }

    @Transactional(readOnly = true)
    public List<Event> getEventsByDate(LocalDate date, UUID userId) {
        return eventRepository.findByOwnerIdAndDate(userId, date);
    }
}