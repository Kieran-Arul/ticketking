package com.kieran.projects.ticketking.ticketkingapplication.application.entity;

import com.kieran.projects.ticketking.ticketkingapplication.application.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ticket ticket;

    public Booking() {}

    public Booking(BookingStatus status, User user, Ticket ticket) {
        this.status = status;
        this.user = user;
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) &&
                status == booking.status &&
                Objects.equals(user, booking.user) &&
                Objects.equals(ticket, booking.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, user, ticket);
    }

}
