package com.yuliia.app.calendar.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;

    private LocalDate date; // исправлено

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
