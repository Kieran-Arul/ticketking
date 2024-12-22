package com.kieran.projects.ticketking.ticketkingapplication.application.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

@Entity
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    private Double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Event event;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seat_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Seat seat;

    public Ticket() {
    }

    public Ticket(Double price, Event event, Seat seat) {
        this.price = price;
        this.event = event;
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) &&
                Objects.equals(price, ticket.price) &&
                Objects.equals(event, ticket.event) &&
                Objects.equals(seat, ticket.seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, event, seat);
    }

}
