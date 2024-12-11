package com.kieran.projects.ticketking.ticketkingapplication.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class Venue {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

    @Positive(message = "Capacity must be positive")
    private Integer capacity;

    public Venue() {}

    public Venue(String name, String address, Integer capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return Objects.equals(id, venue.id) &&
                Objects.equals(name, venue.name) &&
                Objects.equals(address, venue.address) &&
                Objects.equals(capacity, venue.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, capacity);
    }

}
