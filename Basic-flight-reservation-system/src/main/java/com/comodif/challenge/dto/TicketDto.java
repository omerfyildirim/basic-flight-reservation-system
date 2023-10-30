package com.comodif.challenge.dto;

import lombok.Data;

@Data
public class TicketDto {
    private Long id;
    private Long customerId;
    private Long flightId;
    private Long paymentId;
    private Long reservationId;
    private Long seatId;
}
