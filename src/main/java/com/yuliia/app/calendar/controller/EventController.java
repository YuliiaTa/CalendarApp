package com.yuliia.app.calendar.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuliia.app.calendar.model.Event;
import com.yuliia.app.calendar.model.User;
import com.yuliia.app.calendar.repository.EventRepository;
import com.yuliia.app.calendar.repository.UserRepository;
import com.yuliia.app.calendar.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event, @RequestHeader("Authorization") String token) {
        String email = JwtUtil.extractEmail(token);
        User user = userRepository.findByEmail(email).orElseThrow();
        event.setOwner(user);
        return ResponseEntity.ok(eventRepository.save(event));
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventRepository.findAll());
    }
}