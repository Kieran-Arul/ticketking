package com.kieran.projects.ticketking.ticketkingapplication.application.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private LocalDate date;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "venue_id", nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Venue venue;

    public Event() {}

    public Event(String name, String description, LocalDate date, LocalTime startTime, LocalTime endTime, Venue venue) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.venue = venue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) &&
                Objects.equals(name, event.name) &&
                Objects.equals(description, event.description) &&
                Objects.equals(date, event.date) &&
                Objects.equals(startTime, event.startTime) &&
                Objects.equals(endTime, event.endTime) &&
                Objects.equals(venue, event.venue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, date, startTime, endTime, venue);
    }

}
