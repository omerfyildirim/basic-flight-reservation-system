package com.comodif.challenge.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightDto {
    private Long id;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private List<Long> reservationIds;
    private List<Long> ticketIds;
    private List<Long> paymentIds;
    private List<Long> seatIds;
    private List<Long> customerIds;
}
