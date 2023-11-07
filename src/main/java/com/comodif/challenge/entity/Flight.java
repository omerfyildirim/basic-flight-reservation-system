package com.comodif.challenge.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @OneToMany(mappedBy = "flight")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "flight")
    private List<Payment> payments;

    @OneToMany(mappedBy = "flight")
    private List<Seat> seats;

    @OneToMany(mappedBy = "flight")
    private List<Customer> customers;

}


