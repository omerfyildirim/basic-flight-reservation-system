package com.comodif.challenge.dto;

import lombok.Data;

@Data
public class SeatDto {
    private Long id;
    private String seatNumber;
    private boolean isOccupied;
    private Long customerId;
    private Long flightId;
    private Long paymentId;
    private Long reservationId;
    private Long ticketId;
}
