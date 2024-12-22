package com.kieran.projects.ticketking.ticketkingapplication.application.entity;

import jakarta.persistence.*;
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

    @Positive(message = "Capacity must be positive")
    private Integer capacity;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    public Venue() {}

    public Venue(String name, Integer capacity, Address address) {
        this.name = name;
        this.capacity = capacity;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return Objects.equals(id, venue.id) &&
                Objects.equals(name, venue.name) &&
                Objects.equals(capacity, venue.capacity) &&
                Objects.equals(address, venue.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capacity, address);
    }

}
