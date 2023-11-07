package com.comodif.challenge.dto;

import lombok.Data;

@Data
public class SeatDto {
    private Long id;
    private String seatNumber;
    private boolean isOccupied;
    private CustomerDto customerDto;
    private FlightDto flightDto;
    private PaymentDto paymentDto;
    private ReservationDto reservationDto;
    private TicketDto ticketDto;
}
