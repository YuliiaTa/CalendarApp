package com.yuliia.app.calendar.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String title;
    private String description;
    private String date;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public void setOwner(User user) {
        this.owner = user;
    }
}
