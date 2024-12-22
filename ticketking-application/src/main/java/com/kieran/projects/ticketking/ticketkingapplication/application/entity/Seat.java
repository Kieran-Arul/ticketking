package com.kieran.projects.ticketking.ticketkingapplication.application.entity;

import com.kieran.projects.ticketking.ticketkingapplication.application.enums.SeatType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

@Entity
@Getter
@Setter
public class Seat {

    @Id
    @GeneratedValue
    private Long id;

    private String row;

    @Positive(message = "Seat number must be positive")
    private Integer number;

    @Enumerated(EnumType.STRING)
    private SeatType type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "venue_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Venue venue;

    public Seat() {}

    public Seat(String row, Integer number, SeatType type, Venue venue) {
        this.row = row;
        this.number = number;
        this.type = type;
        this.venue = venue;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(id, seat.id) &&
                Objects.equals(row, seat.row) &&
                Objects.equals(number, seat.number) &&
                type == seat.type &&
                Objects.equals(venue, seat.venue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, row, number, type, venue);
    }

}
