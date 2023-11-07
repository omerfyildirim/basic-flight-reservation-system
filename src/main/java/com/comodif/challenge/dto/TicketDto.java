package com.comodif.challenge.dto;

import lombok.Data;

@Data
public class TicketDto {
    private Long id;
    private CustomerDto customerDto;
    private FlightDto flightDto;
    private PaymentDto paymentDto;
    private ReservationDto reservationDto;
    private SeatDto seatDto;
}
