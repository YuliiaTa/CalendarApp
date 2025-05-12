package com.yuliia.app.calendar.controller;

import com.yuliia.app.calendar.model.EventDTO;
import com.yuliia.app.calendar.model.Event;
import com.yuliia.app.calendar.service.CustomUserDetails;
import com.yuliia.app.calendar.service.EventService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO,
                                              @AuthenticationPrincipal CustomUserDetails userDetails) {
        Event event = convertToEntity(eventDTO);
        Event savedEvent = eventService.saveEvent(event, userDetails.getUsername());
        return ResponseEntity.ok(convertToDTO(savedEvent));
    }

    @GetMapping("/by-date/{date}")
    public List<EventDTO> getEventsByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @AuthenticationPrincipal CustomUserDetails userDetails) {
        
        UUID userId = userDetails.getUser().getId();
        return eventService.getEventsByDate(date, userId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Вспомогательные методы преобразования
    private EventDTO convertToDTO(Event event) {
        return new EventDTO(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getDate()
        );
    }

    private Event convertToEntity(EventDTO eventDTO) {
        Event event = new Event();
        event.setTitle(eventDTO.getTitle());
        event.setDescription(eventDTO.getDescription());
        event.setDate(eventDTO.getDate());
        return event;
    }
}