package com.comodif.challenge.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal price;
    private String bankResponse;

    private LocalDateTime paymentTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @OneToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;
}