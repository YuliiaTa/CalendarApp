package com.yuliia.app.calendar.model;

import java.time.LocalDate;
import java.util.UUID;

public class EventDTO {
    private UUID id;
    private String title;
    private String description;
    private LocalDate date; // исправлено

    public EventDTO() {}

    public EventDTO(UUID id, String title, String description, LocalDate date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    // геттеры/сеттеры
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
